package com.se2.bankingsystem.domains.Transaction.sub.WithdrawTransaction;

import com.se2.bankingsystem.domains.Transaction.base.AbstractTransactionService;
import com.se2.bankingsystem.domains.Transaction.sub.WithdrawTransaction.dto.CreateWithdrawTransactionDTO;
import com.se2.bankingsystem.domains.Transaction.sub.WithdrawTransaction.dto.UpdateWithdrawTransactionDTO;
import com.se2.bankingsystem.domains.Transaction.sub.WithdrawTransaction.entity.WithdrawTransaction;

import java.util.List;

public interface WithdrawTransactionService extends AbstractTransactionService<WithdrawTransaction, CreateWithdrawTransactionDTO, UpdateWithdrawTransactionDTO> {
    List<WithdrawTransaction> findAllByWalletId(Long walletId);
}
