package com.coderbank.transaction_service.dto.response;

import com.coderbank.transaction_service.model.TransactionStatus;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public class TransactionResponse {
    private UUID id;
    private UUID accountId;
    private BigDecimal amount;
    private String currency;
    private String description;
    private TransactionStatus status;
    private Instant createdAt;

    public TransactionResponse() {}

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

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

    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
}
