package com.coderbank.transaction_service.mapper;

import com.coderbank.transaction_service.dto.response.AccountResponseDTO;
import com.coderbank.transaction_service.model.Account;


public class AccountMapper {

    public static AccountResponseDTO toResponse(Account account){
        return new AccountResponseDTO(
                account.getId(),
                account.getCustomerId(),
                account.getBalance(),
                account.getCreatedAt()
        );
    }


}
