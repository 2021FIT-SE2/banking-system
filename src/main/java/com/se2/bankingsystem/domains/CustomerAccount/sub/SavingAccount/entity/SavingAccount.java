package com.se2.bankingsystem.domains.CustomerAccount.sub.SavingAccount.entity;

import com.se2.bankingsystem.config.exception.BankingSystemException;
import com.se2.bankingsystem.domains.CustomerAccount.behaviours.Withdrawable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Table(name = "saving_accounts")
@DiscriminatorValue(value = AccountType.Constants.SAVING_VALUE)
public class SavingAccount extends CustomerAccount implements Withdrawable {

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

    @Override
    public void withdraw(@Positive Long amount) throws BankingSystemException {
        if (amount > currentSaving)
            throw new BankingSystemException("Cannot withdraw with amount bigger than current saving");

        LocalDate now = LocalDate.now();
        LocalDate endDate = now.plusMonths(savingDuration.getMonthValue());

        if (now.isBefore(endDate))
            throw new BankingSystemException("Cannot withdraw from saving account when still in saving duration");

        setCurrentSaving(this.getCurrentSaving() - amount);
    }
}
