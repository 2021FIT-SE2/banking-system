package com.se2.bankingsystem.domains.Customer.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
public class CreateCustomerDTO {

    @NotNull
    private String name;

    @NotNull
    private String phoneNumber;

    @NotNull
    private String email;

    @JsonIgnore
    private final LocalDateTime createdAt = LocalDateTime.now();

    @JsonIgnore
    private final LocalDateTime editedAt = LocalDateTime.now();
}
