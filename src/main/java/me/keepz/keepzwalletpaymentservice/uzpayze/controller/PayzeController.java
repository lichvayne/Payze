package me.keepz.keepzwalletpaymentservice.uzpayze.controller;

import lombok.RequiredArgsConstructor;
import me.keepz.keepzwalletpaymentservice.uzpayze.facade.PayzeFacade;
import me.keepz.keepzwalletpaymentservice.uzpayze.model.hook.payload.PayzePayload;
import me.keepz.keepzwalletpaymentservice.uzpayze.model.request.PaymentParam;
import me.keepz.keepzwalletpaymentservice.uzpayze.model.response.PaymentUrlResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/payze/pay")
public class PayzeController {

    private final PayzeFacade payzeFacade;

    @PostMapping
    public ResponseEntity<PaymentUrlResponse> justPay(@RequestBody PaymentParam paymentParam) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(payzeFacade.justPay(paymentParam));
    }


    @PostMapping("/hook")
    public ResponseEntity<Void> webhookEndpoint(@RequestBody PayzePayload payload) {
        payzeFacade.updateTransaction(payload);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

}
