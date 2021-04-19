package com.se2.bankingsystem.domains.Transaction.sub.TransferTransaction.entity;

import com.se2.bankingsystem.domains.CustomerAccount.entity.CustomerAccount;
import com.se2.bankingsystem.domains.Transaction.entity.Transaction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "transfer_transactions")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class TransferTransaction extends Transaction {

    @Positive
    @NotNull
    private Long transferAmount;

    @ManyToOne
    @JoinColumn(name = "address_id") // thông qua khóa ngoại address_id
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private CustomerAccount receiver;
}
