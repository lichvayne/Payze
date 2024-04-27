package me.keepz.keepzwalletpaymentservice.uzpayze.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentUrlResponse {

    @JsonProperty(value = "payment_url")
    private String paymentUrl;

}
