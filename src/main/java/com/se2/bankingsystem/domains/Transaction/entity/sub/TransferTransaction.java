package com.se2.bankingsystem.domains.Transaction.entity.sub;

import com.se2.bankingsystem.domains.Transaction.entity.Transaction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "transfer_transactions")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class TransferTransaction extends Transaction {
    private Long transferAmount;
}
