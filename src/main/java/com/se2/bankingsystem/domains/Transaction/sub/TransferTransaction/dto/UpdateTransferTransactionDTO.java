package com.se2.bankingsystem.domains.Transaction.sub.TransferTransaction.dto;

import com.se2.bankingsystem.domains.Transaction.dto.UpdateTransactionDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class UpdateTransferTransactionDTO extends UpdateTransactionDTO {

    private Long transferAmount;

    private String BeneficialAccount;

    private String status;
}
