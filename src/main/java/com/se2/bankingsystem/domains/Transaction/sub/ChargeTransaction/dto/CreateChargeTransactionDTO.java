package com.se2.bankingsystem.domains.Transaction.sub.ChargeTransaction.dto;

import com.se2.bankingsystem.domains.Transaction.dto.CreateTransactionDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CreateChargeTransactionDTO extends CreateTransactionDTO {

    private Long redeemAmount;
}
