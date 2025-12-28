package com.coderbank.transaction_service.controller;

import com.coderbank.transaction_service.dto.request.TransactionRequestDTO;
import com.coderbank.transaction_service.dto.response.TransactionResponseDTO;
import com.coderbank.transaction_service.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {


    private final TransactionService transactionService;

    public TransactionController(TransactionService service) {
        this.transactionService = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<TransactionResponseDTO> createTransaction(@Valid @RequestBody TransactionRequestDTO transactionRequestDTO) {

        TransactionResponseDTO transactionResponseDTO = transactionService.create(transactionRequestDTO);

        URI location = URI.create(String.format("/api/v1/transactions/%s", transactionResponseDTO.id()));

        return ResponseEntity.created(location).body(transactionResponseDTO);


        
             
        
       
    }




    @GetMapping("/{id}")
    public ResponseEntity<List<TransactionResponseDTO>> getTransactions(@PathVariable("id") UUID id) {

        TransactionResponseDTO transactionResponseDTO = transactionService.getTransactionById(id);

        return ResponseEntity.ok(List.of(transactionResponseDTO));


    }


}
