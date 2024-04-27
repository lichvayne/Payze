package me.keepz.keepzwalletpaymentservice.uzpayze.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import me.keepz.keepzwalletpaymentservice.uzpayze.model.enums.Currency;

@Getter
@Setter
public class PaymentParam {

    @JsonProperty(value = "amount")
    private Double amount;

    @JsonProperty(value = "currency")
    private Currency currency;

    @JsonProperty(value = "user_id")
    private String userId;

}
