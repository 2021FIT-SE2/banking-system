package com.se2.bankingsystem.domains.Authentication.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class LoginRequestDTO {

    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private String token;
}
