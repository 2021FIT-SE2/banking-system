package com.se2.bankingsystem.domains.CustomerAccount.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class CreateCustomerAccountDTO {
    @NotNull
    private Long customerID;
}
