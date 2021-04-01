package com.se2.bankingsystem.domains.Transaction.sub.ChargeTransaction;

import com.se2.bankingsystem.base.CRUDService;
import com.se2.bankingsystem.domains.Transaction.TransactionService;
import com.se2.bankingsystem.domains.Transaction.dto.UpdateTransactionDTO;
import com.se2.bankingsystem.domains.Transaction.sub.ChargeTransaction.dto.CreateChargeTransactionDTO;
import com.se2.bankingsystem.domains.Transaction.sub.ChargeTransaction.entity.ChargeTransaction;
import org.springframework.stereotype.Repository;

@Repository
public interface ChargeTransactionService extends TransactionService, CRUDService<ChargeTransaction, Long, CreateChargeTransactionDTO, UpdateTransactionDTO> {
}
