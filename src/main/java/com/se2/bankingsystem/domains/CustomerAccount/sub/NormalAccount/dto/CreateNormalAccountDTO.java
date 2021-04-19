package com.se2.bankingsystem.domains.CustomerAccount.sub.NormalAccount.dto;

import com.se2.bankingsystem.domains.CustomerAccount.dto.CreateCustomerAccountDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class CreateNormalAccountDTO extends CreateCustomerAccountDTO {

    @NotNull
    @PositiveOrZero
    private Long balance;
}
