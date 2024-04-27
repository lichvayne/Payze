package me.keepz.keepzwalletpaymentservice.uzpayze.model.hook.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import me.keepz.keepzwalletpaymentservice.uzpayze.model.enums.Currency;
import me.keepz.keepzwalletpaymentservice.uzpayze.model.enums.PaymentSource;
import me.keepz.keepzwalletpaymentservice.uzpayze.model.enums.PaymentStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class PayzePayload {

    @JsonProperty("Source")
    private PaymentSource source;

    @JsonProperty("IdempotencyKey")
    private UUID idempotencyKey;

    @JsonProperty("PaymentId")
    private String paymentId;

    @JsonProperty("Type")
    private String type;

    @JsonProperty("Sandbox")
    private boolean sandbox;

    @JsonProperty("PaymentStatus")
    private PaymentStatus status;

    @JsonProperty("Amount")
    private Double amount;

    @JsonProperty("FinalAmount")
    private Double finalAmount;

    @JsonProperty("Currency")
    private Currency currency;

    @JsonProperty("RRN")
    private String rrm;

    @JsonProperty("Commission")
    private Double commission;

    @JsonProperty("Preauthorized")
    private boolean preauthorized;

    @JsonProperty("CanBeCaptured")
    private boolean canBeCaptured;

    @JsonProperty("CreateDate")
    private Long createDate;

    @JsonProperty("CreateDateIso")
    private LocalDateTime createDateIso;

    @JsonProperty("CaptureDate")
    private Long captureDate;

    @JsonProperty("CaptureDateIso")
    private LocalDateTime captureDateIso;

    @JsonProperty("BlockDate")
    private Long blockDate;

    @JsonProperty("BlockDateIso")
    private LocalDateTime blockDateIso;

    @JsonProperty("Token")
    private String token;

    @JsonProperty("CardMask")
    private String cardMask;

    @JsonProperty("CardOrigination")
    private String cardOrigination;

    @JsonProperty("CardOwnerEntityType")
    private String cardOwnerEntityType;

    @JsonProperty("CardBrand")
    private String cardBrand;

    @JsonProperty("CardCountry")
    private String cardCountry;

    @JsonProperty("CardHolder")
    private String cardHolder;

    @JsonProperty("ExpirationDate")
    private String expirationDate;

    @JsonProperty("SecureCardId")
    private String secureCardId;

    @JsonProperty("RejectionReason")
    private String rejectionReason;

    @JsonProperty("Refund")
    private Refund refund;

    @JsonProperty("Splits")
    private List<Object> splits;

    @JsonProperty("Metadata")
    private Object metadata;

    @JsonProperty("Payer")
    private Payer payer;

    @Getter
    @Setter
    public class Refund {

        @JsonProperty("RefundId")
        private String refundId;

        @JsonProperty("Status")
        private String status;

        @JsonProperty("Refundable")
        private boolean refundable;

        @JsonProperty("Amount")
        private Double amount;

        @JsonProperty("RequestedAmount")
        private Double requestedAmount;

        @JsonProperty("RejectReason")
        private String rejectReason;

        @JsonProperty("RefundDate")
        private Long refundDate;

        @JsonProperty("RefundDateIso")
        private String refundDateIso;

        @JsonProperty("Revisions")
        private List<Object> revisions;

    }

    @Getter
    @Setter
    public class Payer {

        @JsonProperty("Phone")
        private String phone;

        @JsonProperty("FullName")
        private String fullName;

    }
}