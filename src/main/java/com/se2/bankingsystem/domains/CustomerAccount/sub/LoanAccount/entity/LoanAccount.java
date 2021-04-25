package com.se2.bankingsystem.domains.CustomerAccount.sub.LoanAccount.entity;

import com.se2.bankingsystem.domains.CustomerAccount.entity.AccountType;
import com.se2.bankingsystem.domains.CustomerAccount.entity.CustomerAccount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Table(name = "loan_accounts")
@DiscriminatorValue(value = AccountType.Constants.LOAN_VALUE)
public class LoanAccount extends CustomerAccount {

    @NotNull
    private LoanDuration loanDuration;

    private LocalDate startDate;

    @PositiveOrZero
    @NotNull
    private Long principal;

    @NotNull
    @PositiveOrZero
    private Long currentLoan;
}
