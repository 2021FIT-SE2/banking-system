package com.se2.bankingsystem.domains.Customer.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
public class UpdateCustomerDTO {
    @Id
    @NotNull
    private Long id;

    private String name;

    private String phoneNumber;

    private String email;

    @JsonIgnore
    private final LocalDateTime editedAt = LocalDateTime.now();
}
