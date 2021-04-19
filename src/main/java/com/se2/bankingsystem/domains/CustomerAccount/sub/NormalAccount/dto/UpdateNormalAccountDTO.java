package com.se2.bankingsystem.domains.CustomerAccount.sub.NormalAccount.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class UpdateNormalAccountDTO {

    private Long customerID;


    private Long balance;
}
