package com.se2.bankingsystem.domains.Transaction.sub.WithdrawTransaction.dto;

import com.se2.bankingsystem.domains.Transaction.dto.CreateTransactionDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class CreateWithdrawTransactionDTO extends CreateTransactionDTO {

    private Long withdrawAmount;
}
