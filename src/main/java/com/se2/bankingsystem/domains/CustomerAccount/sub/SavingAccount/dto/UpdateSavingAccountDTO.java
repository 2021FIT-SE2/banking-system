package com.se2.bankingsystem.domains.CustomerAccount.sub.SavingAccount.dto;

import com.se2.bankingsystem.domains.CustomerAccount.dto.UpdateCustomerAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.sub.SavingAccount.entity.SavingDuration;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class UpdateSavingAccountDTO extends UpdateCustomerAccountDTO {

    private SavingDuration savingDuration;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @PositiveOrZero
    private Long principal;

    @PositiveOrZero
    private Long currentSaving;
}
