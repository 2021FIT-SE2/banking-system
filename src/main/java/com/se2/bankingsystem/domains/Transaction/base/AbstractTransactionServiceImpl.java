package com.se2.bankingsystem.domains.Transaction.base;

import com.se2.bankingsystem.domains.CustomerAccount.CustomerAccountRepository;
import com.se2.bankingsystem.domains.CustomerAccount.entity.CustomerAccount;
import com.se2.bankingsystem.domains.Transaction.dto.CreateTransactionDTO;
import com.se2.bankingsystem.domains.Transaction.dto.UpdateTransactionDTO;
import com.se2.bankingsystem.domains.Transaction.entity.Transaction;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@AllArgsConstructor
public abstract class AbstractTransactionServiceImpl<T extends Transaction, C extends CreateTransactionDTO, U extends UpdateTransactionDTO> implements AbstractTransactionService<T, C, U> {

    protected final CustomerAccountRepository customerAccountRepository;
    protected final AbstractTransactionRepository<T> abstractTransactionRepository;
    protected final ModelMapper modelMapper;

    protected void setCustomerAccount(Transaction transaction, String customerAccountID) {
        CustomerAccount customerAccount = customerAccountRepository.findById(customerAccountID).orElseThrow(EntityNotFoundException::new);
        transaction.setCustomerAccount(customerAccount);
    }

    @Override
    public void deleteById(Long id) {
        this.abstractTransactionRepository.deleteById(id);
    }

    @Override
    public List<T> findAll() {
        return this.abstractTransactionRepository.findAll();
    }

    @Override
    public List<T> findAllByCustomerAccountId(String customerAccountId) {
        return abstractTransactionRepository.findAllByCustomerAccountId(customerAccountId);
    }

    @Override
    public T getById(Long id) {
        return this.abstractTransactionRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        return this.abstractTransactionRepository.findAll(pageable);
    }

    @Override
    public List<T> findAllByCustomerId(Long customerId) {
        return this.abstractTransactionRepository.findAllByCustomerAccountCustomerId(customerId);
    }
}
