package com.se2.bankingsystem.domains.Transaction.sub.TransferTransaction;

import com.se2.bankingsystem.domains.Transaction.sub.TransferTransaction.entity.TransferTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferTransactionRepository extends JpaRepository<TransferTransaction, Long> {
}
