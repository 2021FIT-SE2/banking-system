package com.se2.bankingsystem.domains.Transaction;

import com.se2.bankingsystem.domains.Transaction.entity.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface TransactionService {
    void setCustomerAccount(Transaction transaction, Long customerID);

    void deleteById(Long id);

    List<Transaction> findAll();

    Transaction getById(Long id);

    Page<Transaction> findAll(Pageable pageable);
}
