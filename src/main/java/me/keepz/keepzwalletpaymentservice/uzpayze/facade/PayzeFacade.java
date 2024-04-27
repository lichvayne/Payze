package me.keepz.keepzwalletpaymentservice.uzpayze.facade;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.keepz.keepzwalletpaymentservice.uzpayze.mapper.TransactionMapper;
import me.keepz.keepzwalletpaymentservice.uzpayze.model.entity.Transaction;
import me.keepz.keepzwalletpaymentservice.uzpayze.model.enums.PaymentSource;
import me.keepz.keepzwalletpaymentservice.uzpayze.model.hook.PayzeHooks;
import me.keepz.keepzwalletpaymentservice.uzpayze.model.hook.payload.PayzePayload;
import me.keepz.keepzwalletpaymentservice.uzpayze.model.request.PaymentParam;
import me.keepz.keepzwalletpaymentservice.uzpayze.model.request.PaymentRequest;
import me.keepz.keepzwalletpaymentservice.uzpayze.model.response.PaymentResponse;
import me.keepz.keepzwalletpaymentservice.uzpayze.model.response.PaymentUrlResponse;
import me.keepz.keepzwalletpaymentservice.uzpayze.service.PayzeService;
import me.keepz.keepzwalletpaymentservice.uzpayze.service.PayzeTransactionService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class PayzeFacade {

    @Value("${uz-payze.webhook-gateway-url}")
    private String webhookGatewayUrl;

    @Value("${uz-payze.create-payment-url}")
    private String createPaymentUrl;

    @Value("${uz-payze.get-payment-url}")
    private String getPaymentUrl;

    @Value("${uz-payze.success-redirect-gateway-url}")
    private String successRedirectGatewayUrl;

    @Value("${uz-payze.error-redirect-gateway-url}")
    private String errorRedirectGatewayUrl;

    @Value("${uz-payze.api-key}")
    private String apiKey;

    @Value("${uz-payze.api-secret}")
    private String apiSecret;

    private HttpHeaders authHeader;
    private final PayzeService payzeService;
    private final RestTemplate restTemplate;
    private final PayzeTransactionService payzeTransactionService;

    @PostConstruct
    private void initializeAuthHeader() {
        HttpHeaders header = new HttpHeaders();
        header.set(HttpHeaders.AUTHORIZATION, apiKey + ":" + apiSecret);
        this.authHeader = header;
    }

    public PaymentUrlResponse justPay(PaymentParam paymentParam) {
        Transaction transaction = TransactionMapper.paymentParamTo(paymentParam);
        transaction.setCreateDate(LocalDateTime.now());
        transaction.setSource(PaymentSource.Card);
        payzeTransactionService.saveTransaction(transaction);

        PayzeHooks hooks = new PayzeHooks();
        hooks.setWebhookGateway(webhookGatewayUrl);
        hooks.setErrorRedirectGateway(errorRedirectGatewayUrl);
        hooks.setSuccessRedirectGateway(successRedirectGatewayUrl);
        PaymentRequest request = PaymentRequest
                .builder()
                .hooks(hooks)
                .idempotencyKey(transaction.getId().toString())
                .source(PaymentSource.Card)
                .amount(paymentParam.getAmount())
                .currency(paymentParam.getCurrency())
                .build();

        return payzeService.sendPayment(request, createPaymentUrl, authHeader);
    }

    public void updateTransaction(PayzePayload payload) {
        String url = getPaymentUrl + "?$filter=transactionId eq '" + payload.getPaymentId() + "'";

        try {
            ResponseEntity<PaymentResponse> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(null, authHeader), PaymentResponse.class);
            PaymentResponse.Value payment = response.getBody().getData().getValue().get(0);

            if (payment == null || !payloadIsValid(payload, payment)) {
                log.info("Get payment object is null or payload not valid");
                return;
            }

            Transaction transaction = payzeTransactionService.getTransactionByPayzeTransactionId(payload.getIdempotencyKey());
            transaction.setStatus(payload.getStatus());
            transaction.setCreateDate(payload.getCreateDateIso());
            transaction.setCapturedDate(payload.getCaptureDateIso());
            transaction.setBlockDateIso(payload.getBlockDateIso());
            transaction.setPaymentId(payload.getPaymentId());

            payzeTransactionService.saveTransaction(transaction);
        } catch (Throwable e) {
            log.error("failed hook endpoint flow, {}", e);
        }
    }

    private boolean payloadIsValid(PayzePayload payload, PaymentResponse.Value payment) {
        return Objects.equals(payload.getPaymentId(), payment.getTransactionId())
                || Objects.equals(payload.getSource(), payment.getSource())
                || Objects.equals(payload.getStatus(), payment.getStatus())
                || Objects.equals(payload.getType(), payment.getType())
                || Objects.equals(payload.getAmount(), payment.getAmount())
                || Objects.equals(payload.getCurrency(), payment.getCurrency());
    }
}
