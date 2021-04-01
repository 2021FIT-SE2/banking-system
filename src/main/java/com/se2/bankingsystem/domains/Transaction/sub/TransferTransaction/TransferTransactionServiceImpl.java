package com.se2.bankingsystem.domains.Transaction.sub.TransferTransaction;

import com.se2.bankingsystem.domains.CustomerAccount.CustomerAccountRepository;
import com.se2.bankingsystem.domains.Transaction.TransactionRepository;
import com.se2.bankingsystem.domains.Transaction.TransactionServiceImpl;
import com.se2.bankingsystem.domains.Transaction.dto.CreateTransactionDTO;
import com.se2.bankingsystem.domains.Transaction.dto.UpdateTransactionDTO;
import com.se2.bankingsystem.domains.Transaction.sub.TransferTransaction.dto.CreateTransferTransactionDTO;
import com.se2.bankingsystem.domains.Transaction.sub.TransferTransaction.entity.TransferTransaction;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class TransferTransactionServiceImpl extends TransactionServiceImpl<TransferTransaction> implements TransferTransactionService {

    @Autowired
    protected TransferTransactionServiceImpl(TransactionRepository<TransferTransaction> transactionRepository, ModelMapper modelMapper, CustomerAccountRepository customerAccountRepository) {
        super(transactionRepository, modelMapper, customerAccountRepository);
    }

    @Override
    public TransferTransaction create(CreateTransferTransactionDTO createTransferTransactionDTO) {

        TransferTransaction transferTransaction = modelMapper.map(createTransferTransactionDTO, TransferTransaction.class);

        setCustomerAccount(transferTransaction, createTransferTransactionDTO.getCustomerAccountID());

        return transactionRepository.save(transferTransaction);
    }

    @Override
    public TransferTransaction updateById(Long id, UpdateTransactionDTO updateTransactionDTO) {

        TransferTransaction transferTransaction = transactionRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        modelMapper.map(updateTransactionDTO, transferTransaction);

        setCustomerAccount(transferTransaction, updateTransactionDTO.getCustomerAccountID());

        return null;
    }
}
