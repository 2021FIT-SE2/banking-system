package com.se2.bankingsystem.domains.CustomerAccount.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.se2.bankingsystem.domains.Authority.entity.AuthorityName;

import com.se2.bankingsystem.domains.Customer.dto.CreateCustomerDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateCustomerAccountDTO {

    private Long customerID;

    private String accountNumber;

    @JsonIgnore
    private final AuthorityName role = AuthorityName.CUSTOMER;
}
