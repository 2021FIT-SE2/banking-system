package com.se2.bankingsystem.domains.Transaction.sub.WithdrawTransaction;

import com.se2.bankingsystem.domains.Transaction.base.AbstractTransactionRepository;
import com.se2.bankingsystem.domains.Transaction.sub.WithdrawTransaction.entity.WithdrawTransaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WithdrawTransactionRepository extends AbstractTransactionRepository<WithdrawTransaction> {
    List<WithdrawTransaction> findAllByWalletId(Long walletId);
}
