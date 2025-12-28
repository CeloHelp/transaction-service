package com.coderbank.transaction_service.dto.request;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

public record AccountRequestDTO(
        @NotNull(message = "Customer ID é obrigatório")
        UUID customerId,
        BigDecimal amount,
        String currency,
        String description
) {
}
