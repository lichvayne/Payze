package me.keepz.keepzwalletpaymentservice.uzpayze.model.response;

import me.keepz.keepzwalletpaymentservice.uzpayze.model.enums.Currency;
import me.keepz.keepzwalletpaymentservice.uzpayze.model.enums.PaymentSource;
import me.keepz.keepzwalletpaymentservice.uzpayze.model.enums.PaymentStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PayzePaymentResponse {

    private PaymentData data;
    private Status status;

    @Getter
    @Setter
    public static class PaymentData {
        private Payment payment;
    }

    @Getter
    @Setter
    public static class Payment {
        private Long id;
        private Long requesterId;
        private String transactionId;
        private String type;
        private PaymentSource source;
        private Double amount;
        private Currency currency;
        private PaymentStatus status;
        private CardPayment cardPayment;
        private WalletPayment walletPayment;
        private Hooks hooks;
        private String language;
        private String idempotencyKey;
        private Object metadata;
        private String shareLink;
        private Object network;
        private Double blockedAmount;
        private Double capturedAmount;
        private Double refundedAmount;
        private Double reversedAmount;
        private Double settledBalanceAmount;
        private Object crossCurrencySettlement;
        private Object settled;
        private String rejectReason;
        private Double fee;
        private Object channel;
        private Object payer;
        private Object receipt;
        private Boolean sandBox;
        private Date capturedDate;
        private Date blockedDate;
        private Date settledDate;
        private Date refundedDate;
        private Date reverseDate;
        private Date rejectedDate;
        private Date createdDate;
        private String paymentUrl;
        private Integer version;
        private String lastModifiedDate;
    }

    @Getter
    @Setter
    public static class CardPayment {
        private Boolean preauthorize;
        private Boolean googlePay;
        private Boolean applePay;
        private Object cardMask;
        private Object cardExpiration;
        private Object merchantId;
        private Object terminalId;
        private String token;
        private Object rrn;
        private Object processingVendorId;
        private Object processingVendor;
        private Object cardOwnerEntityType;
        private Object secureCardId;
    }

    @Getter
    @Setter
    public static class WalletPayment {
        // Properties for WalletPayment
    }

    @Getter
    @Setter
    public static class Hooks {
        private String webhookGateway;
        private String successRedirectGateway;
        private String errorRedirectGateway;
    }

    @Getter
    @Setter
    public static class Status {
        private String message;
        private String errors;
        private String type;
    }
}