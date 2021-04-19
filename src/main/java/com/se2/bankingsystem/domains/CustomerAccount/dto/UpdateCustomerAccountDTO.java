package com.se2.bankingsystem.domains.CustomerAccount.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@Builder
public class UpdateCustomerAccountDTO {
    @NotNull
    private Long customerID;
}
