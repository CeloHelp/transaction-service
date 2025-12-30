package com.coderbank.transaction_service.service;

import com.coderbank.transaction_service.dto.request.AccountRequestDTO;
import com.coderbank.transaction_service.dto.response.AccountResponseDTO;
import com.coderbank.transaction_service.mapper.AccountMapperStruct;
import com.coderbank.transaction_service.model.Account;
import com.coderbank.transaction_service.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    private final AccountMapperStruct accountMapperStruct;

    public AccountResponseDTO create(AccountRequestDTO accountRequest) {
        Account account = accountMapperStruct.toEntity(accountRequest);

        accountRepository.save(account);

        return accountMapperStruct.toResponse(account);
    }

    public List<AccountResponseDTO> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();

        return accountMapperStruct.toResponseList(accounts);
    }
}
