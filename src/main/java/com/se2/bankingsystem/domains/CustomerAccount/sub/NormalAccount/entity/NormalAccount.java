package com.se2.bankingsystem.domains.CustomerAccount.sub.NormalAccount.entity;

import com.se2.bankingsystem.domains.CustomerAccount.entity.AccountType;
import com.se2.bankingsystem.domains.CustomerAccount.entity.CustomerAccount;
import com.se2.bankingsystem.domains.CustomerAccount.sub.interfaces.Chargeable;
import com.se2.bankingsystem.domains.CustomerAccount.sub.interfaces.Transferable;
import com.se2.bankingsystem.domains.CustomerAccount.sub.interfaces.Withdrawable;
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
    public void charge(Long amount) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void transfer(Long amount, CustomerAccount receiver) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void withdraw(Long amount) {
        throw new UnsupportedOperationException();
    }
}
