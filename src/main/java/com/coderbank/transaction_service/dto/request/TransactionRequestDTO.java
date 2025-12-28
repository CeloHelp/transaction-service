package com.coderbank.transaction_service.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

public record TransactionRequestDTO(
        @NotNull
        UUID accountId,
        BigDecimal amount,
        @NotNull
        String currency,
        String description
) {
}


