package com.se2.bankingsystem.domains.Transaction;

import com.se2.bankingsystem.config.exception.BankingSystemException;
import com.se2.bankingsystem.domains.CustomerAccount.CustomerAccountRepository;
import com.se2.bankingsystem.domains.Transaction.base.AbstractTransactionServiceImpl;
import com.se2.bankingsystem.domains.Transaction.dto.CreateTransactionDTO;
import com.se2.bankingsystem.domains.Transaction.dto.UpdateTransactionDTO;
import com.se2.bankingsystem.domains.Transaction.entity.Transaction;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl extends AbstractTransactionServiceImpl<Transaction, CreateTransactionDTO, UpdateTransactionDTO> implements TransactionService {
    public TransactionServiceImpl(CustomerAccountRepository customerAccountRepository, TransactionRepository transactionRepository, ModelMapper modelMapper) {
        super(customerAccountRepository, transactionRepository, modelMapper);
    }

    @Override
    public Transaction create(CreateTransactionDTO modelType) throws BankingSystemException {
        return null;
    }

    @Override
    public Transaction updateById(Long id, UpdateTransactionDTO modelType) {
        return null;
    }
}
