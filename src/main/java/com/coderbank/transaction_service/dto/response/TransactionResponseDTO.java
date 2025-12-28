package com.coderbank.transaction_service.dto.response;

import com.coderbank.transaction_service.model.enums.TransactionStatus;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;
import java.lang.String;

public record TransactionResponseDTO(
        UUID id,
        UUID accountId,
        BigDecimal amount,
        String currency,
        String description,
        TransactionStatus status,
        Instant createdAt
) {
}
