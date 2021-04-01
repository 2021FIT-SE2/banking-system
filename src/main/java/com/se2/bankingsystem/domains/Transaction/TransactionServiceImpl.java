package com.se2.bankingsystem.domains.Transaction;

import com.se2.bankingsystem.domains.CustomerAccount.CustomerAccountRepository;
import com.se2.bankingsystem.domains.CustomerAccount.entity.CustomerAccount;
import com.se2.bankingsystem.domains.Transaction.entity.Transaction;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class TransactionServiceImpl<T extends Transaction> implements TransactionService {

    protected final TransactionRepository<T> transactionRepository;
    protected final ModelMapper modelMapper;
    protected final CustomerAccountRepository customerAccountRepository;

    protected TransactionServiceImpl(TransactionRepository<T> transactionRepository, ModelMapper modelMapper, CustomerAccountRepository customerAccountRepository) {
        this.transactionRepository = transactionRepository;
        this.modelMapper = modelMapper;
        this.customerAccountRepository = customerAccountRepository;
    }

    protected void setCustomerAccount(T transaction, Long customerAccountID) {
        CustomerAccount customerAccount = customerAccountRepository.findById(customerAccountID).orElseThrow(EntityNotFoundException::new);
        transaction.setCustomerAccount(customerAccount);
    }

    public void deleteById(Long id) {
        transactionRepository.deleteById(id);
    }

    public List<T> findAll() {
        return transactionRepository.findAll();
    }

    public T getById(Long id) {
        return transactionRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Page<T> findAll(Pageable pageable) {
        return transactionRepository.findAll(pageable);
    }
}
