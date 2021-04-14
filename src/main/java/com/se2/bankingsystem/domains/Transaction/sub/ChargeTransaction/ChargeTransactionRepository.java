package com.se2.bankingsystem.domains.Transaction.sub.ChargeTransaction;

import com.se2.bankingsystem.domains.Transaction.sub.ChargeTransaction.entity.ChargeTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChargeTransactionRepository extends JpaRepository<ChargeTransaction, Long> {
}
