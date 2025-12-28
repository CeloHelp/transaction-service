package com.coderbank.transaction_service.mapper;

import com.coderbank.transaction_service.dto.request.TransactionRequestDTO;
import com.coderbank.transaction_service.dto.response.TransactionResponseDTO;
import com.coderbank.transaction_service.model.Transaction;

import java.util.List;
import java.util.stream.Collectors;

public class TransactionMapper {
    public static TransactionResponseDTO toResponse(Transaction transaction){
        return new TransactionResponseDTO(
                transaction.getId(),
                transaction.getAccountId(),
                transaction.getAmount(),
                transaction.getCurrency(),
                transaction.getDescription(),
                transaction.getStatus(),
                transaction.getCreatedAt()


        );
    }

    public static List<TransactionResponseDTO> toResponseList(List<Transaction> transactions){
        return transactions.stream()
                .map(TransactionMapper::toResponse)
                .collect(Collectors.toList());
    }

    public static void updateEntity(Transaction entity, TransactionRequestDTO transactionRequestDTO){
        entity.setAmount(transactionRequestDTO.amount());
        entity.setCurrency(transactionRequestDTO.currency());
        entity.setDescription(transactionRequestDTO.description());
    }
}
