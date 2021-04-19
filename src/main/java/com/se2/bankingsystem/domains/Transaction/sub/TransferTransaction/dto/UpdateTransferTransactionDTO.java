package com.se2.bankingsystem.domains.Transaction.sub.TransferTransaction.dto;

import com.se2.bankingsystem.domains.Transaction.dto.UpdateTransactionDTO;
import lombok.AllArgsConstructor;
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
public class UpdateTransferTransactionDTO extends UpdateTransactionDTO {

    @NotNull
    @Positive
    private Long transferAmount;

    @NotNull
    private String receiver;

    @NotNull
    private String status;
}
