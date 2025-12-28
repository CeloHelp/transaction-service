package com.coderbank.transaction_service.model;

import com.coderbank.transaction_service.model.enums.AccountStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_accounts") // Nome da tabela no banco
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    // Vínculo lógico com o Customer Service (Sem FK de banco, apenas o ID)
    // unique = true garante que um cliente tenha apenas UMA conta (regra 1:1)
    @Column(nullable = false, unique = true)
    private UUID customerId;

    // Regra de Ouro: Dinheiro SEMPRE é BigDecimal
    @Column(nullable = false)
    private BigDecimal balance;

    @Enumerated(EnumType.STRING) // Salva "ACTIVE" no banco em vez de 0
    @Column(nullable = false)
    private AccountStatus status;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    // ---- Gatilhos Automáticos (Igual usamos no Fallback) ----

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();

        // Garante que a conta nasça zerada se ninguém passar saldo
        if (this.balance == null) {
            this.balance = BigDecimal.ZERO;
        }

        // Garante que a conta nasça ativa
        if (this.status == null) {
            this.status = AccountStatus.ACTIVE;
        }
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
