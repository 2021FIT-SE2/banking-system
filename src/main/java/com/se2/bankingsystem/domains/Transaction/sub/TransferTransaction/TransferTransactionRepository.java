package com.se2.bankingsystem.domains.Transaction.sub.TransferTransaction;

import com.se2.bankingsystem.domains.Transaction.TransactionRepository;
import com.se2.bankingsystem.domains.Transaction.sub.TransferTransaction.entity.TransferTransaction;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferTransactionRepository extends TransactionRepository<TransferTransaction> {
}
