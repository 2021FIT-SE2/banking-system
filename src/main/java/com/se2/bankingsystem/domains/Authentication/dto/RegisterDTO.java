package com.se2.bankingsystem.domains.Authentication.dto;

import com.se2.bankingsystem.domains.Customer.dto.CreateCustomerDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDTO {

    private String token;

    private CreateCustomerDTO createCustomerDTO;
}
