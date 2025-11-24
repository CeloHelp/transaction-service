package com.coderbank.transaction_service.controller;

import com.coderbank.transaction_service.dto.request.TransactionRequest;
import com.coderbank.transaction_service.dto.response.TransactionResponse;
import com.coderbank.transaction_service.model.Transaction;
import com.coderbank.transaction_service.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {

    private final TransactionService service;

    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TransactionResponse create(@RequestBody TransactionRequest request) {
        Transaction saved = service.create(request);
        return toResponse(saved);
    }

    @GetMapping("/by-account/{accountId}")
    public List<TransactionResponse> findByAccount(@PathVariable UUID accountId) {
        return service.findByAccount(accountId).stream().map(this::toResponse).collect(Collectors.toList());
    }

    private TransactionResponse toResponse(Transaction t) {
        TransactionResponse r = new TransactionResponse();
        r.setId(t.getId());
        r.setAccountId(t.getAccountId());
        r.setAmount(t.getAmount());
        r.setCurrency(t.getCurrency());
        r.setDescription(t.getDescription());
        r.setStatus(t.getStatus());
        r.setCreatedAt(t.getCreatedAt());
        return r;
    }
}
