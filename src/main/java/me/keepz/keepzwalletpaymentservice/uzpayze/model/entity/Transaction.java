package me.keepz.keepzwalletpaymentservice.uzpayze.model.entity;

import jakarta.persistence.*;
import lombok.*;
import me.keepz.keepzwalletpaymentservice.uzpayze.model.enums.Currency;
import me.keepz.keepzwalletpaymentservice.uzpayze.model.enums.PaymentSource;
import me.keepz.keepzwalletpaymentservice.uzpayze.model.enums.PaymentStatus;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "uz_payze_transaction")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "source")
    @Enumerated(value = EnumType.STRING)
    private PaymentSource source;

    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    private PaymentStatus status;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "paymentId")
    private String paymentId;

    @Column(name = "commission")
    private Double commision;

    @Column(name = "currency")
    @Enumerated(value = EnumType.STRING)
    private Currency currency;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Column(name = "captured_date")
    private LocalDateTime capturedDate;

    @Column(name = "block_date")
    private LocalDateTime blockDateIso;

    @Column(name = "user_id")
    private String userId;

}
