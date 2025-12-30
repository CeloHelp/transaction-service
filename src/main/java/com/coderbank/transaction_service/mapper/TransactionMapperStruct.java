package com.coderbank.transaction_service.mapper;

import com.coderbank.transaction_service.dto.request.TransactionRequestDTO;
import com.coderbank.transaction_service.dto.response.TransactionResponseDTO;
import com.coderbank.transaction_service.model.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Component
@Mapper(componentModel = "spring")
public interface TransactionMapperStruct {

    // Converter DTO de Requisição para Transaction
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    Transaction toEntity(TransactionRequestDTO dto);

    // Converter Transaction para DTO de Resposta
    TransactionResponseDTO toResponse(Transaction transaction);

    // Método customizado para criar bônus inicial
    default Transaction createInitialBonus(UUID transactionId) {
        Transaction transaction = new Transaction();
        transaction.setId(transactionId);
        transaction.setAmount(new BigDecimal("50.00"));
        transaction.setCurrency("BRL");
        transaction.setDescription("Initial Bonus");
        transaction.setCreatedAt(Instant.now());
        return transaction;
    }
}

