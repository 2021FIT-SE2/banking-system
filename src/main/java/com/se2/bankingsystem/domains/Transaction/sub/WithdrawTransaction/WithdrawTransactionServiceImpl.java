package com.se2.bankingsystem.domains.Transaction.sub.WithdrawTransaction;

import com.se2.bankingsystem.domains.CustomerAccount.CustomerAccountRepository;
import com.se2.bankingsystem.domains.CustomerAccount.entity.CustomerAccount;
import com.se2.bankingsystem.domains.Transaction.entity.Transaction;
import com.se2.bankingsystem.domains.Transaction.sub.WithdrawTransaction.dto.CreateWithdrawTransactionDTO;
import com.se2.bankingsystem.domains.Transaction.sub.WithdrawTransaction.dto.UpdateWithdrawTransactionDTO;
import com.se2.bankingsystem.domains.Transaction.sub.WithdrawTransaction.entity.WithdrawTransaction;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class WithdrawTransactionServiceImpl implements WithdrawTransactionService {

    private final CustomerAccountRepository customerAccountRepository;

    private final ModelMapper modelMapper;

    private final WithdrawTransactionRepository transferTransactionRepository;

    @Autowired
    public WithdrawTransactionServiceImpl(WithdrawTransactionRepository transferTransactionRepository, ModelMapper modelMapper, CustomerAccountRepository customerAccountRepository) {
        this.modelMapper = modelMapper;
        this.transferTransactionRepository = transferTransactionRepository;
        this.customerAccountRepository = customerAccountRepository;
    }

    public void setCustomerAccount(Transaction transaction, String customerAccountID) {
        CustomerAccount customerAccount = customerAccountRepository.findById(customerAccountID).orElseThrow(EntityNotFoundException::new);
        transaction.setCustomerAccount(customerAccount);
    }

    @Override
    public WithdrawTransaction create(CreateWithdrawTransactionDTO createWithdrawTransactionDTO) {

        WithdrawTransaction transferTransaction = modelMapper.map(createWithdrawTransactionDTO, WithdrawTransaction.class);

        setCustomerAccount(transferTransaction, createWithdrawTransactionDTO.getCustomerAccountID());

        return transferTransactionRepository.save(transferTransaction);
    }

    @Override
    public WithdrawTransaction updateById(Long id, UpdateWithdrawTransactionDTO updateTransactionDTO) {

        WithdrawTransaction transferTransaction = transferTransactionRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        modelMapper.map(updateTransactionDTO, transferTransaction);

        setCustomerAccount(transferTransaction, updateTransactionDTO.getCustomerAccountID());

        return transferTransaction;
    }

    @Override
    public void deleteById(Long id) {
        this.transferTransactionRepository.deleteById(id);
    }

    @Override
    public List<WithdrawTransaction> findAll() {
        return this.transferTransactionRepository.findAll();
    }

    @Override
    public WithdrawTransaction getById(Long id) {
        return this.transferTransactionRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Page<WithdrawTransaction> findAll(Pageable pageable) {
        return this.transferTransactionRepository.findAll(pageable);
    }
}
