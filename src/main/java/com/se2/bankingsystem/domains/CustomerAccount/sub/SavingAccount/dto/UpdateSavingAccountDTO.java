package com.se2.bankingsystem.domains.CustomerAccount.sub.SavingAccount.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class UpdateSavingAccountDTO {

    @PositiveOrZero
    @NotNull
    private Double rate;

    @PositiveOrZero
    @NotNull
    private Integer duration;

    @FutureOrPresent
    private LocalDate startAt;

    @FutureOrPresent
    private LocalDate endAt;

    @PositiveOrZero
    @NotNull
    private Long principal;

    @PositiveOrZero
    @NotNull
    private Long interest;
}
