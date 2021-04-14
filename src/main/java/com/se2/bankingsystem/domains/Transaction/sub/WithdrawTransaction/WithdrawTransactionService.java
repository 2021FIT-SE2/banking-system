package com.se2.bankingsystem.domains.Transaction.sub.WithdrawTransaction;

import com.se2.bankingsystem.base.CRUDService;
import com.se2.bankingsystem.domains.Transaction.sub.WithdrawTransaction.dto.CreateWithdrawTransactionDTO;
import com.se2.bankingsystem.domains.Transaction.sub.WithdrawTransaction.dto.UpdateWithdrawTransactionDTO;
import com.se2.bankingsystem.domains.Transaction.sub.WithdrawTransaction.entity.WithdrawTransaction;
import org.springframework.stereotype.Repository;

public interface WithdrawTransactionService extends CRUDService<WithdrawTransaction, Long, CreateWithdrawTransactionDTO, UpdateWithdrawTransactionDTO> {
}
