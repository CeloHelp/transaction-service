package com.coderbank.transaction_service.service;

import com.coderbank.transaction_service.dto.request.AccountRequestDTO;
import com.coderbank.transaction_service.dto.response.AccountResponseDTO;
import com.coderbank.transaction_service.model.Account;
import com.coderbank.transaction_service.repository.AccountRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor

public class AccountService {
    private final AccountRepository accountRepository;

       public AccountResponseDTO createAccount (AccountRequestDTO accountRequestDTO){
           Account account = new Account();





       }

}
