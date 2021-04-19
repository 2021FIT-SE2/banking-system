package com.se2.bankingsystem.domains.Transaction;

import com.se2.bankingsystem.domains.CustomerAccount.CustomerAccountRepository;
import com.se2.bankingsystem.domains.CustomerAccount.entity.CustomerAccount;
import com.se2.bankingsystem.domains.Transaction.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    private CustomerAccountRepository customerAccountRepository;

    private TransactionRepository transactionRepository;

    @Autowired
    public void setTransactionRepository(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Autowired
    public void setCustomerAccountRepository(CustomerAccountRepository customerAccountRepository) {
        this.customerAccountRepository = customerAccountRepository;
    }

    public void setCustomerAccount(Transaction transaction, String customerAccountID) {
        CustomerAccount customerAccount = customerAccountRepository.findById(customerAccountID).orElseThrow(EntityNotFoundException::new);
        transaction.setCustomerAccount(customerAccount);
    }

    @Override
    public void deleteById(Long id) {
        this.transactionRepository.deleteById(id);
    }

    @Override
    public List<Transaction> findAll() {
        return this.transactionRepository.findAll();
    }

    @Override
    public Transaction getById(Long id) {
        return this.transactionRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Page<Transaction> findAll(Pageable pageable) {
        return this.transactionRepository.findAll(pageable);
    }
}
