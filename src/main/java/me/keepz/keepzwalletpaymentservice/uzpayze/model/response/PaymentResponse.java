package me.keepz.keepzwalletpaymentservice.uzpayze.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import me.keepz.keepzwalletpaymentservice.uzpayze.model.enums.Currency;
import me.keepz.keepzwalletpaymentservice.uzpayze.model.enums.PaymentSource;
import me.keepz.keepzwalletpaymentservice.uzpayze.model.enums.PaymentStatus;

import java.util.List;

@Getter
@Setter
public class PaymentResponse {

    @JsonProperty(value = "data")
    private Data data;

    @JsonProperty(value = "status")
    private Status status;

    @Getter
    @Setter
    public class Data {

        @JsonProperty(value = "value")
        private List<Value> value;

        @JsonProperty(value = "count")
        private int count;

    }

    @Getter
    @Setter
    public static class Value {

        @JsonProperty("id")
        private Integer id;

        @JsonProperty("requesterId")
        private Integer requesterId;

        @JsonProperty("transactionId")
        private String transactionId;

        @JsonProperty("type")
        private String type;

        @JsonProperty("source")
        private PaymentSource source;

        @JsonProperty("amount")
        private Double amount;

        @JsonProperty("currency")
        private Currency currency;

        @JsonProperty("status")
        private PaymentStatus status;

        @JsonProperty("cardPayment")
        private CardPayment cardPayment;

    }

    @Getter
    @Setter
    public static class CardPayment {

        @JsonProperty("preauthorize")
        private boolean preauthorize;

        @JsonProperty("googlePay")
        private boolean googlePay;

        @JsonProperty("applePay")
        private boolean applePay;

        @JsonProperty("cardMask")
        private String cardMask;

        @JsonProperty("cardExpiration")
        private String cardExpiration;

        @JsonProperty("merchantId")
        private String merchantId;

        @JsonProperty("terminalId")
        private String terminalId;

        @JsonProperty("token")
        private String token;

        @JsonProperty("rrn")
        private String rrn;

        @JsonProperty("processingVendorId")
        private String processingVendorId;

        @JsonProperty("processingVendor")
        private String processingVendor;

        @JsonProperty("cardOwnerEntityType")
        private String cardOwnerEntityType;

        @JsonProperty("secureCardId")
        private String secureCardId;

    }


    @Getter
    @Setter
    public class Status {

        @JsonProperty("message")
        private String message;

        @JsonProperty("errors")
        private String errors;

        @JsonProperty("type")
        private String type;

    }
}