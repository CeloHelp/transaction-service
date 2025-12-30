package com.coderbank.transaction_service.mapper;

import com.coderbank.transaction_service.dto.request.AccountRequestDTO;
import com.coderbank.transaction_service.dto.response.AccountResponseDTO;
import com.coderbank.transaction_service.model.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface AccountMapperStruct {

    // Converter DTO de Requisição para Account
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "balance", source = "amount")
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Account toEntity(AccountRequestDTO dto);

    // Converter Account para DTO de Resposta
    @Mapping(target = "accountId", source = "id")
    @Mapping(target = "status", expression = "java(account.getStatus().toString())")
    AccountResponseDTO toResponse(Account account);

    // Converter lista de Account para lista de DTO de Resposta
    List<AccountResponseDTO> toResponseList(List<Account> accounts);

    // Método de atualização (Merge) - atualiza Account existente com dados do DTO
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "balance", source = "amount")
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updateFromRequest(@MappingTarget Account account, AccountRequestDTO dto);
}

