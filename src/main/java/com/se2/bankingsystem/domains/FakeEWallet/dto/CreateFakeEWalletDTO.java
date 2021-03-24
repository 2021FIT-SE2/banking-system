package com.se2.bankingsystem.domains.FakeEWallet.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.se2.bankingsystem.domains.Authority.entity.AuthorityName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateFakeEWalletDTO {

    private Long customerID;

    private String accountNumber;

    @JsonIgnore
    private final AuthorityName role = AuthorityName.CUSTOMER;
}
