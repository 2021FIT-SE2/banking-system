package com.se2.bankingsystem.domains.CustomerAccount.sub.NormalAccount.entity;

import com.se2.bankingsystem.config.exception.BankingSystemException;
import com.se2.bankingsystem.domains.CustomerAccount.entity.AccountType;
import com.se2.bankingsystem.domains.CustomerAccount.entity.CustomerAccount;
import com.se2.bankingsystem.domains.CustomerAccount.behaviours.Chargeable;
import com.se2.bankingsystem.domains.CustomerAccount.behaviours.Transferable;
import com.se2.bankingsystem.domains.CustomerAccount.behaviours.Withdrawable;
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

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Table(name = "normal_accounts")
@DiscriminatorValue(value = AccountType.Constants.NORMAL_VALUE)
public class NormalAccount extends CustomerAccount implements Chargeable, Transferable, Withdrawable {

    @NotNull
    @PositiveOrZero
    private Long balance;

    @Override
    public void charge(@PositiveOrZero Long amount) throws BankingSystemException {
        Long newBalance = this.balance + amount;
        this.setBalance(newBalance);
    }

    @Override
    public void transfer(@PositiveOrZero Long amount, @NotNull Chargeable receiver) throws BankingSystemException {
        if (amount > balance) {
            throw new BankingSystemException("Transfer amount must be smaller than current balance");
        } else {
            this.balance -= amount;
            receiver.charge(amount);
        }
    }

    @Override
    public void withdraw(@PositiveOrZero Long amount) throws BankingSystemException {
        if (amount > balance) {
            throw new BankingSystemException("Withdraw amount must be smaller than current balance");
        } else {
            this.balance -= amount;
        }
    }
}
