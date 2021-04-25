package com.se2.bankingsystem.domains.CustomerAccount.sub.SavingAccount.entity;

import com.se2.bankingsystem.domains.CustomerAccount.entity.AccountType;
import com.se2.bankingsystem.domains.CustomerAccount.entity.CustomerAccount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDate;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Table(name = "saving_accounts")
@DiscriminatorValue(value = AccountType.Constants.SAVING_VALUE)
public class SavingAccount extends CustomerAccount {

    @NotNull
    private SavingDuration savingDuration;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @PositiveOrZero
    @NotNull
    private Long principal;

    @NotNull
    @PositiveOrZero
    private Long currentSaving;
}
