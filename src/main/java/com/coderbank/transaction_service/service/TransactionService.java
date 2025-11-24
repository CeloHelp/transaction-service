package com.coderbank.transaction_service.service;

import com.coderbank.transaction_service.model.Transaction;
import com.coderbank.transaction_service.model.TransactionStatus;
import com.coderbank.transaction_service.repository.TransactionRepository;
import com.coderbank.transaction_service.dto.request.TransactionRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TransactionService {

    private final TransactionRepository repository;

    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    public Transaction create(TransactionRequest request) {
        Transaction t = new Transaction(
                request.getAccountId(),
                request.getAmount(),
                request.getCurrency(),
                request.getDescription()
        );
        t.setStatus(TransactionStatus.PENDING);
        return repository.save(t);
    }

    public List<Transaction> findByAccount(UUID accountId) {
        return repository.findByAccountIdOrderByCreatedAtDesc(accountId);
    }
}
