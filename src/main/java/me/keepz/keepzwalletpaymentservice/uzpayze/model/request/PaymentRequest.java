package me.keepz.keepzwalletpaymentservice.uzpayze.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import me.keepz.keepzwalletpaymentservice.uzpayze.model.enums.Currency;
import me.keepz.keepzwalletpaymentservice.uzpayze.model.enums.PaymentLanguage;
import me.keepz.keepzwalletpaymentservice.uzpayze.model.enums.PaymentSource;
import me.keepz.keepzwalletpaymentservice.uzpayze.model.hook.PayzeHooks;

import java.util.List;

@Getter
@Setter
@Builder
public class PaymentRequest {

    @JsonProperty("Source")
    private PaymentSource source;

    @JsonProperty("Amount")
    private Double amount;

    @JsonProperty("Currency")
    private Currency currency;

    @JsonProperty("Language")
    private PaymentLanguage language;

    @JsonProperty("IdempotencyKey")
    private String idempotencyKey;

    @JsonProperty("CardPayment")
    private CardPayment cardPayment;

    @JsonProperty("Hooks")
    private PayzeHooks hooks;

    @JsonProperty("Metadata")
    private Metadata metadata;

    @JsonProperty("PayoutSplit")
    private List<PayoutSplit> payoutSplit;

    @JsonProperty("ShareLink")
    private ShareLink shareLink;

    @JsonProperty("Token")
    private String token;

    @Getter
    @Setter
    public class CardPayment {

        @JsonProperty("Preauthorize")
        private boolean preauthorize;

        @JsonProperty("TokenizeCard")
        private boolean tokenizeCard;

        @JsonProperty("ApplePay")
        private boolean applePay;

    }

    @Getter
    @Setter
    public class Metadata {

        @JsonProperty("Channel")
        private String channel;

        @JsonProperty("Order")
        private Order order;

        @JsonProperty("ExtraAttributes")
        private List<ExtraAttribute> extraAttributes;

    }

    @Getter
    @Setter
    public class Order {

        @JsonProperty("OrderId")
        private String orderId;

        @JsonProperty("OrderItems")
        private List<OrderItem> orderItems;

        @JsonProperty("UzRegulatoryOrderDetails")
        private UzRegulatoryOrderDetails uzRegulatoryOrderDetails;

        @JsonProperty("BillingAddress")
        private BillingAddress billingAddress;

        @JsonProperty("ShippingAddress")
        private ShippingAddress shippingAddress;

    }

    @Getter
    @Setter
    public class OrderItem {

        @JsonProperty("ProductLink")
        private String productLink;

        @JsonProperty("ProductImage")
        private String productImage;

        @JsonProperty("ProductName")
        private String productName;

        @JsonProperty("ProductCode")
        private String productCode;

        @JsonProperty("ProductBarCode")
        private String productBarCode;

        @JsonProperty("ProductLabel")
        private String productLabel;

        @JsonProperty("PackageCode")
        private String packageCode;

        @JsonProperty("ProductQuantity")
        private int productQuantity;

        @JsonProperty("Price")
        private double price;

        @JsonProperty("SumPrice")
        private double sumPrice;

        @JsonProperty("Vat")
        private double vat;

        @JsonProperty("VatPercent")
        private double vatPercent;

        @JsonProperty("Discount")
        private double discount;

        @JsonProperty("AdditionalDiscount")
        private double additionalDiscount;

        @JsonProperty("UzRegulatoryOrderItem")
        private UzRegulatoryOrderItem uzRegulatoryOrderItem;

    }

    @Getter
    @Setter
    public class UzRegulatoryOrderItem {
        @JsonProperty("CommissionInfoTin")
        private String commissionInfoTin;
        @JsonProperty("CommissionInfoPinfl")
        private String commissionInfoPinfl;
    }

    @Getter
    @Setter
    public class UzRegulatoryOrderDetails {
        @JsonProperty("Latitude")
        private Double latitude;
        @JsonProperty("Longitude")
        private Double longitude;
        @JsonProperty("TaxiVehicleNumber")
        private String taxiVehicleNumber;
        @JsonProperty("TaxiTin")
        private String taxiTin;
        @JsonProperty("TaxiPinfl")
        private String taxiPinfl;
    }

    @Getter
    @Setter
    public class BillingAddress {
        @JsonProperty("FirstName")
        private String firstName;
        @JsonProperty("LastName")
        private String lastName;
        @JsonProperty("City")
        private String city;
        @JsonProperty("Country")
        private String country;
        @JsonProperty("Line1")
        private String line1;
        @JsonProperty("Line2")
        private String line2;
        @JsonProperty("PostalCode")
        private String postalCode;
        @JsonProperty("State")
        private String state;
        @JsonProperty("PhoneNumber")
        private String phoneNumber;
        @JsonProperty("PersonalId")
        private String personalId;
        @JsonProperty("TaxId")
        private String taxId;
    }

    @Getter
    @Setter
    public class ShippingAddress {
        @JsonProperty("FirstName")
        private String firstName;
        @JsonProperty("LastName")
        private String lastName;
        @JsonProperty("City")
        private String city;
        @JsonProperty("Country")
        private String country;
        @JsonProperty("Line1")
        private String line1;
        @JsonProperty("Line2")
        private String line2;
        @JsonProperty("PostalCode")
        private String postalCode;
        @JsonProperty("State")
        private String state;
        @JsonProperty("PhoneNumber")
        private String phoneNumber;
        @JsonProperty("PersonalId")
        private String personalId;
        @JsonProperty("TaxId")
        private String taxId;
    }

    @Getter
    @Setter
    public class ExtraAttribute {
        @JsonProperty("Key")
        private String key;
        @JsonProperty("Value")
        private String value;
        @JsonProperty("Description")
        private String description;
    }

    @Getter
    @Setter
    public class PayoutSplit {
        @JsonProperty("Amount")
        private double amount;
        @JsonProperty("PayoutAccount")
        private PayoutAccount payoutAccount;
        @JsonProperty("DelayPayoutDays")
        private int delayPayoutDays;
        @JsonProperty("Description")
        private String description;
    }

    @Getter
    @Setter
    public class PayoutAccount {
        @JsonProperty("OwnerName")
        private String ownerName;
        @JsonProperty("OwnerPersonalId")
        private String ownerPersonalId;
        @JsonProperty("OwnerTaxId")
        private String ownerTaxId;
        @JsonProperty("Iban")
        private String iban;
    }

    @Getter
    @Setter
    public class ShareLink {
        @JsonProperty("Email")
        private String email;
        @JsonProperty("SmsPhone")
        private String smsPhone;
    }
}