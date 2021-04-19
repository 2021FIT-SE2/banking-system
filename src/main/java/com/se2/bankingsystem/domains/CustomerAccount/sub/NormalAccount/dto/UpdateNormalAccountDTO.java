package com.se2.bankingsystem.domains.CustomerAccount.sub.NormalAccount.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class UpdateNormalAccountDTO {

    @NotNull
    @PositiveOrZero
    private Long balance;
}
