package com.se2.bankingsystem.domains.Transaction.sub.TransferTransaction.dto;

import com.se2.bankingsystem.domains.Transaction.dto.CreateTransactionDTO;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class CreateTransferTransactionDTO extends CreateTransactionDTO {

    private String beneficialAccount;

    private Long transferAmount;

    private String status;
}
