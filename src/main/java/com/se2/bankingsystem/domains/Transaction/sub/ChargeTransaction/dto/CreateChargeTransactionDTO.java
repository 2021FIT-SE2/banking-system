package com.se2.bankingsystem.domains.Transaction.sub.ChargeTransaction.dto;

import com.se2.bankingsystem.domains.Transaction.dto.CreateTransactionDTO;
import lombok.*;
import lombok.experimental.SuperBuilder;


@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class CreateChargeTransactionDTO extends CreateTransactionDTO {

    private Long redeemAmount;
}
