package com.se2.bankingsystem.domains.Transaction.sub.WithdrawTransaction.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.se2.bankingsystem.domains.Transaction.dto.CreateTransactionDTO;
import com.se2.bankingsystem.domains.Transaction.entity.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class CreateWithdrawTransactionDTO extends CreateTransactionDTO {

    @NotNull
    @Positive
    private Long withdrawAmount;

    @JsonIgnore
    @Builder.Default
    private TransactionType transactionType = TransactionType.WITHDRAW;

    private Long walletID;
}
