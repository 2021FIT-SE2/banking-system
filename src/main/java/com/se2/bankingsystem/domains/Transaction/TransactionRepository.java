package com.se2.bankingsystem.domains.Transaction;

import com.se2.bankingsystem.domains.Transaction.base.AbstractTransactionRepository;
import com.se2.bankingsystem.domains.Transaction.entity.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends AbstractTransactionRepository<Transaction> {
}
