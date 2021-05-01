package com.se2.bankingsystem.domains.Transaction.sub.TransferTransaction;

import com.se2.bankingsystem.config.exception.BankingSystemException;
import com.se2.bankingsystem.domains.CustomerAccount.CustomerAccountRepository;
import com.se2.bankingsystem.domains.CustomerAccount.entity.CustomerAccount;
import com.se2.bankingsystem.domains.CustomerAccount.behaviours.Chargeable;
import com.se2.bankingsystem.domains.CustomerAccount.behaviours.Transferable;
import com.se2.bankingsystem.domains.Transaction.base.AbstractTransactionServiceImpl;
import com.se2.bankingsystem.domains.Transaction.sub.TransferTransaction.dto.CreateTransferTransactionDTO;
import com.se2.bankingsystem.domains.Transaction.sub.TransferTransaction.dto.UpdateTransferTransactionDTO;
import com.se2.bankingsystem.domains.Transaction.sub.TransferTransaction.entity.TransferTransaction;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
@Transactional
public class TransferTransactionServiceImpl extends AbstractTransactionServiceImpl<TransferTransaction, CreateTransferTransactionDTO, UpdateTransferTransactionDTO> implements TransferTransactionService {
    
    public TransferTransactionServiceImpl(CustomerAccountRepository customerAccountRepository, TransferTransactionRepository transactionRepository, ModelMapper modelMapper) {
        super(customerAccountRepository, transactionRepository, modelMapper);
    }

    @Override
    public TransferTransaction create(CreateTransferTransactionDTO createTransferTransactionDTO) throws BankingSystemException {

        if (createTransferTransactionDTO.getCustomerAccountID().equals(createTransferTransactionDTO.getReceiverID()))
            throw new BankingSystemException("Transfer account and receiver account must not be the same");

        TransferTransaction transferTransaction = modelMapper.map(createTransferTransactionDTO, TransferTransaction.class);

        setCustomerAccount(transferTransaction, createTransferTransactionDTO.getCustomerAccountID());

        CustomerAccount customerAccount = transferTransaction.getCustomerAccount();

        CustomerAccount receiver = customerAccountRepository.findById(createTransferTransactionDTO.getReceiverID()).orElseThrow(EntityNotFoundException::new);
        transferTransaction.setReceiver(receiver);

        if (!(customerAccount instanceof Transferable))
            throw new BankingSystemException("Account type not supported for transfer transaction");

        if (!(receiver instanceof Chargeable))
            throw new BankingSystemException("Receiver Account type not supported for charging, could not perform transfer");

        ((Transferable) customerAccount).transfer(transferTransaction.getTransferAmount(), (Chargeable) receiver);

        customerAccountRepository.save(customerAccount);
        customerAccountRepository.save(receiver);

        return abstractTransactionRepository.save(transferTransaction);
    }

    @Override
    public TransferTransaction updateById(Long id, UpdateTransferTransactionDTO updateTransactionDTO) {
        TransferTransaction transferTransaction = abstractTransactionRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        modelMapper.map(updateTransactionDTO, transferTransaction);
        setCustomerAccount(transferTransaction, updateTransactionDTO.getCustomerAccountID());
        return transferTransaction;
    }
}
