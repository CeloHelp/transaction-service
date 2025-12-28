package com.coderbank.transaction_service.service;

import com.coderbank.transaction_service.dto.request.AccountRequestDTO;
import com.coderbank.transaction_service.dto.response.AccountResponseDTO;
import com.coderbank.transaction_service.model.Account;
import com.coderbank.transaction_service.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountResponseDTO create(AccountRequestDTO accountRequest) {
        Account account = new Account();
        account.setCustomerId(accountRequest.customerId()); // Vincula o dono
        account.setBalance(BigDecimal.ZERO);         // Saldo inicial zerado
        account.setCreatedAt(LocalDateTime.now());

        accountRepository.save(account);

        return new AccountResponseDTO(
                account.getId(),
                account.getCustomerId(),
                account.getBalance(),
                account.getStatus().name(),
                account.getCreatedAt()

        );

    }
}
