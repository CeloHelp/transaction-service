package com.coderbank.transaction_service.repository;

import com.coderbank.transaction_service.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, UUID > {

    Optional<Account> findByCustomerId(UUID customerId);



    boolean existsByCustomerId(UUID customerId);
}
