package com.coderbank.transaction_service.factory;

import com.coderbank.transaction_service.dto.request.TransactionRequestDTO;
import com.coderbank.transaction_service.model.Transaction;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public class TransactionFactory {

    public static Transaction  createFromRequest(TransactionRequestDTO transactionRequestDTO) {
        return new Transaction(
                transactionRequestDTO.accountId(),
                transactionRequestDTO.amount(),
                transactionRequestDTO.currency(),
                transactionRequestDTO.description()
        );

    }

    public static final BigDecimal BONUS_VALUE = new BigDecimal("50.00");
    public static Transaction createInitialBonus(UUID transactionId) {
        Transaction transaction = new Transaction();

        transaction.setId(transactionId);
        transaction.setAmount(TransactionFactory.BONUS_VALUE);
        transaction.setCurrency("BRL");
        transaction.setDescription("Initial Bonus");
        transaction.setCreatedAt(Instant.now());
        return transaction;
    }
}
