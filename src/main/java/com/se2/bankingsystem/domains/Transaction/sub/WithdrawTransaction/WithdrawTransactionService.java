package com.se2.bankingsystem.domains.Transaction.sub.WithdrawTransaction;

import com.se2.bankingsystem.base.CRUDService;
import com.se2.bankingsystem.domains.Transaction.TransactionService;
import com.se2.bankingsystem.domains.Transaction.dto.UpdateTransactionDTO;
import com.se2.bankingsystem.domains.Transaction.sub.WithdrawTransaction.dto.CreateWithDrawTransactionDTO;
import com.se2.bankingsystem.domains.Transaction.sub.WithdrawTransaction.entity.WithdrawTransaction;
import org.springframework.stereotype.Repository;

@Repository
public interface WithdrawTransactionService extends TransactionService, CRUDService<WithdrawTransaction, Long, CreateWithDrawTransactionDTO, UpdateTransactionDTO> {
}
