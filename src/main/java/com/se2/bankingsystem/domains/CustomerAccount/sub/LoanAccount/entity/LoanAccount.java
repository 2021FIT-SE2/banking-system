package com.se2.bankingsystem.domains.CustomerAccount.sub.LoanAccount.entity;

import com.se2.bankingsystem.domains.CustomerAccount.entity.CustomerAccount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Table(name = "loan_accounts")
public class LoanAccount extends CustomerAccount {

    @PositiveOrZero
    @NotNull
    private Double rate;

    @PositiveOrZero
    @NotNull
    private Integer duration;

    @FutureOrPresent
    private LocalDateTime startAt;

    @FutureOrPresent
    private LocalDateTime endAt;

    @PositiveOrZero
    @NotNull
    private Long principal;

    @PositiveOrZero
    @NotNull
    private Long interest;
}
