package com.coderbank.transaction_service.service;

import com.coderbank.transaction_service.dto.response.TransactionResponseDTO;
import com.coderbank.transaction_service.mapper.TransactionMapperStruct;
import com.coderbank.transaction_service.model.Transaction;
import com.coderbank.transaction_service.repository.TransactionRepository;
import com.coderbank.transaction_service.dto.request.TransactionRequestDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final TransactionMapperStruct transactionMapperStruct;

    public TransactionService(TransactionRepository repository, TransactionMapperStruct transactionMapperStruct) {
        this.transactionRepository = repository;
        this.transactionMapperStruct = transactionMapperStruct;
    }

    public TransactionResponseDTO create(TransactionRequestDTO transactionRequestDTO) {

        Transaction transaction = transactionMapperStruct.toEntity(transactionRequestDTO);

        transaction.registerAmount(transactionRequestDTO.amount());

        Transaction bonusTransaction = transactionMapperStruct.createInitialBonus(transaction.getId());

        transactionRepository.save(transaction);

        return transactionMapperStruct.toResponse(transaction);
    }

    public TransactionResponseDTO getTransactionById(UUID id) {

        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));

        return transactionMapperStruct.toResponse(transaction);
    }
}

