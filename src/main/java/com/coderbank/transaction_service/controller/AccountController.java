package com.coderbank.transaction_service.controller;

import com.coderbank.transaction_service.dto.request.AccountRequestDTO;
import com.coderbank.transaction_service.dto.response.AccountResponseDTO;
import com.coderbank.transaction_service.service.AccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {
    private final AccountService accountService;



    @PostMapping
    public ResponseEntity<AccountResponseDTO> createAccount(@Valid @RequestBody AccountRequestDTO accountRequest) {
        AccountResponseDTO accountResponseDTO = accountService.create(accountRequest);

        return ResponseEntity.status(201).body(accountResponseDTO);

    }
}
