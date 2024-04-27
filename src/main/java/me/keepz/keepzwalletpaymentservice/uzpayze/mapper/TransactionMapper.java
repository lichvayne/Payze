package me.keepz.keepzwalletpaymentservice.uzpayze.mapper;

import me.keepz.keepzwalletpaymentservice.uzpayze.model.entity.Transaction;
import me.keepz.keepzwalletpaymentservice.uzpayze.model.enums.PaymentStatus;
import me.keepz.keepzwalletpaymentservice.uzpayze.model.request.PaymentParam;

public class TransactionMapper {

    public static Transaction paymentParamTo(PaymentParam paymentParam) {
        return Transaction
                .builder()
                .currency(paymentParam.getCurrency())
                .amount(paymentParam.getAmount())
                .userId(paymentParam.getUserId())
                .status(PaymentStatus.NotProcessed)
                .build();
    }

}
