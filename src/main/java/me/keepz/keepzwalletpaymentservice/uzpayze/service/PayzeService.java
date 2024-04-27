package me.keepz.keepzwalletpaymentservice.uzpayze.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.keepz.keepzwalletpaymentservice.uzpayze.model.request.PaymentRequest;
import me.keepz.keepzwalletpaymentservice.uzpayze.model.response.PaymentUrlResponse;
import me.keepz.keepzwalletpaymentservice.uzpayze.model.response.PayzePaymentResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class PayzeService {

    private final RestTemplate restTemplate;

    public PaymentUrlResponse sendPayment(PaymentRequest paymentRequest, String url, HttpHeaders httpHeader) {
        PaymentUrlResponse paymentUrlResponse = new PaymentUrlResponse();
        try {
            ResponseEntity<PayzePaymentResponse> response = restTemplate.exchange(url, HttpMethod.PUT, new HttpEntity<>(paymentRequest, httpHeader), PayzePaymentResponse.class);
            if (response.getStatusCode().isError()) {
                log.info("could not send create payment request to payze, status: {} ", response.getStatusCode());
            }

            String paymentUrl = Objects.requireNonNull(response
                            .getBody())
                    .getData()
                    .getPayment()
                    .getPaymentUrl();
            paymentUrlResponse.setPaymentUrl(paymentUrl);
        } catch (Throwable e) {
            log.info("could not create payment, {}", e);
        }
        return paymentUrlResponse;
    }

}
