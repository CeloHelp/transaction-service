package com.coderbank.transaction_service.service.dto;

import java.math.BigDecimal;
import java.util.UUID;

import com.coderbank.transaction_service.model.TransactionStatus;

public class TransactionRequest {
    private UUID accountId;
    private BigDecimal amount;
    private String currency;
    private String description;
    private TransactionStatus status;

    public TransactionRequest() {}

    public UUID getAccountId() { return accountId; }
    public void setAccountId(UUID accountId) { this.accountId = accountId; }

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }

    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public TransactionStatus getStatus() { return status; }
    public void setStatus(TransactionStatus status) { this.status = status; }
}
