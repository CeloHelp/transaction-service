package com.coderbank.transaction_service.service;

import com.coderbank.transaction_service.dto.response.TransactionResponseDTO;
import com.coderbank.transaction_service.mapper.TransactionMapper;
import com.coderbank.transaction_service.model.Transaction;
import com.coderbank.transaction_service.repository.TransactionRepository;
import com.coderbank.transaction_service.dto.request.TransactionRequestDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository repository) {
        this.transactionRepository = repository;
    }

    public TransactionResponseDTO create(TransactionRequestDTO transactionRequestDTO) {

        Transaction transaction = transaction;

        transaction.registerAmount(transactionRequestDTO.amount());

        Transaction bonusTransaction = TransactionFactory.createInitialBonus(transaction.getId());

        transactionRepository.save(transaction);

        return TransactionMapper.toResponse(transaction);


    }

    public TransactionResponseDTO getTransactionById(UUID id) {

        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));

        return TransactionMapper.toResponse(transaction);
    }
}

