package com.coderbank.transaction_service.model;

import com.coderbank.transaction_service.model.enums.TransactionStatus;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private UUID accountId;

    @Column(nullable = false, precision = 14, scale = 2)
    private BigDecimal amount;

    @Column(nullable = false, length = 3)
    private String currency;

    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private TransactionStatus status;

    @Column(nullable = false)
    private Instant createdAt;

    public Transaction() {}

    public Transaction(UUID accountId, BigDecimal amount, String currency, String description) {
        this.accountId = accountId;
        this.amount = amount;
        this.currency = currency;
        this.description = description;
    }

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

    @PrePersist
    void prePersist() {
        if (this.createdAt == null) {
            this.createdAt = Instant.now();
        }
        if (this.status == null) {
            this.status = TransactionStatus.PENDING;
        }
    }

    // Lógica Amount

   public void registerAmount (BigDecimal incomingAmount) {
        if (incomingAmount == null || incomingAmount.compareTo(BigDecimal.ZERO) <= 0) {
            this.status = TransactionStatus.FAILED;
        }
        this.amount = incomingAmount;

        this.status = TransactionStatus.COMPLETED;
    }


    private static final BigDecimal BONUS_VALUE = new BigDecimal("50.00"); //Constante do valor do bônus// //Sempre usar BigDecimal para valores monetários

    public void bonusTransaction ( UUID accountId ){


        this.accountId = accountId;

        this.status = TransactionStatus.COMPLETED;

        this.amount = BONUS_VALUE;

        this.createdAt = Instant.now();


    }

   }

