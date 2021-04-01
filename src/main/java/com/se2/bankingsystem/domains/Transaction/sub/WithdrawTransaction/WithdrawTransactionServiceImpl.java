package com.se2.bankingsystem.domains.Transaction.sub.WithdrawTransaction;

import com.se2.bankingsystem.domains.CustomerAccount.CustomerAccountRepository;
import com.se2.bankingsystem.domains.Transaction.TransactionRepository;
import com.se2.bankingsystem.domains.Transaction.TransactionServiceImpl;
import com.se2.bankingsystem.domains.Transaction.dto.UpdateTransactionDTO;
import com.se2.bankingsystem.domains.Transaction.sub.WithdrawTransaction.dto.CreateWithDrawTransactionDTO;
import com.se2.bankingsystem.domains.Transaction.sub.WithdrawTransaction.entity.WithdrawTransaction;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WithdrawTransactionServiceImpl extends TransactionServiceImpl<WithdrawTransaction> implements WithdrawTransactionService {

    @Autowired
    protected WithdrawTransactionServiceImpl(TransactionRepository<WithdrawTransaction> transactionRepository, ModelMapper modelMapper, CustomerAccountRepository customerAccountRepository) {
        super(transactionRepository, modelMapper, customerAccountRepository);
    }

    @Override
    public WithdrawTransaction create(CreateWithDrawTransactionDTO createWithDrawTransactionDTO) {
        return null;
    }

    @Override
    public WithdrawTransaction updateById(Long id, UpdateTransactionDTO updateTransactionDTO) {
        return null;
    }
}
