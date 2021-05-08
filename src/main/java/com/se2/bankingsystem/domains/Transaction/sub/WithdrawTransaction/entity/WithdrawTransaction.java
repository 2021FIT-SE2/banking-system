package com.se2.bankingsystem.domains.Transaction.sub.WithdrawTransaction.entity;

import com.se2.bankingsystem.domains.FakeEWallet.entity.FakeEWallet;
import com.se2.bankingsystem.domains.Transaction.entity.Transaction;
import com.se2.bankingsystem.domains.Transaction.entity.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "withdraw_transactions")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@DiscriminatorValue(TransactionType.Constants.WITHDRAW_VALUE)
public class WithdrawTransaction extends Transaction {

    @NotNull
    @Positive
    private Long withdrawAmount;

    @ManyToOne
    @JoinColumn(name = "wallet_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private FakeEWallet wallet;
}
