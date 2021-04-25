package com.se2.bankingsystem.domains.Transaction;

import com.se2.bankingsystem.domains.Transaction.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findAllByCustomerAccountId(String customerAccountId);
}
