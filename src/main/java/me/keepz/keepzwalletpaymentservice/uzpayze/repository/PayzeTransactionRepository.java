package me.keepz.keepzwalletpaymentservice.uzpayze.repository;

import me.keepz.keepzwalletpaymentservice.uzpayze.model.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PayzeTransactionRepository extends JpaRepository<Transaction, String> {

    @Query("SELECT transaction FROM Transaction transaction WHERE transaction.id= :payzeTransactionId")
    Optional<Transaction> getTransactionByPayzeTransactionId(@Param("payzeTransactionId") UUID payzeTransactionId);
}
