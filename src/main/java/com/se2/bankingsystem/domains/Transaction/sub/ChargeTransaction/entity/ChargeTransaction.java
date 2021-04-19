package com.se2.bankingsystem.domains.Transaction.sub.ChargeTransaction.entity;

import com.se2.bankingsystem.domains.Transaction.entity.Transaction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "charge_transactions")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ChargeTransaction extends Transaction {

    @NotNull
    private Long redeemAmount;
}
