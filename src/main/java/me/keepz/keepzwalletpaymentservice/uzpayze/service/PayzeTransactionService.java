package me.keepz.keepzwalletpaymentservice.uzpayze.service;

import me.keepz.keepzwalletpaymentservice.uzpayze.model.entity.Transaction;
import me.keepz.keepzwalletpaymentservice.uzpayze.repository.PayzeTransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PayzeTransactionService {

    private final PayzeTransactionRepository payzeTransactionRepository;

    @Transactional
    public void saveTransaction(Transaction transaction) {
        payzeTransactionRepository.save(transaction);
    }

    public Transaction getTransactionByPayzeTransactionId(UUID payzeTransactionId){
        //TODO replace with custom exception
        return payzeTransactionRepository
                .getTransactionByPayzeTransactionId(payzeTransactionId)
                .orElseThrow(() -> new RuntimeException("Not found"));
    }
}
