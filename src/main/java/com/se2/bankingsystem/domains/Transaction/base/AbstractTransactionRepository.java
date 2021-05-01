package com.se2.bankingsystem.domains.Transaction.base;

import com.se2.bankingsystem.domains.Transaction.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AbstractTransactionRepository<T extends Transaction> extends JpaRepository<T, Long> {

    List<T> findAllByCustomerAccountId(String customerAccountId);

    List<T> findAllByCustomerAccountCustomerId(Long customerId);
}
