package com.se2.bankingsystem.domains.Transaction.sub.TransferTransaction;

import com.se2.bankingsystem.domains.CustomerAccount.CustomerAccountRepository;
import com.se2.bankingsystem.domains.CustomerAccount.entity.CustomerAccount;
import com.se2.bankingsystem.domains.Transaction.entity.Transaction;
import com.se2.bankingsystem.domains.Transaction.sub.TransferTransaction.dto.CreateTransferTransactionDTO;
import com.se2.bankingsystem.domains.Transaction.sub.TransferTransaction.dto.UpdateTransferTransactionDTO;
import com.se2.bankingsystem.domains.Transaction.sub.TransferTransaction.entity.TransferTransaction;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@AllArgsConstructor
public class TransferTransactionServiceImpl implements TransferTransactionService {

    private final ModelMapper modelMapper;

    private final CustomerAccountRepository customerAccountRepository;

    private final TransferTransactionRepository transferTransactionRepository;

    public void setCustomerAccount(Transaction transaction, String customerAccountID) {
        CustomerAccount customerAccount = customerAccountRepository.findById(customerAccountID).orElseThrow(EntityNotFoundException::new);
        transaction.setCustomerAccount(customerAccount);
    }

    @Override
    public TransferTransaction create(CreateTransferTransactionDTO createTransferTransactionDTO) {
        TransferTransaction transferTransaction = modelMapper.map(createTransferTransactionDTO, TransferTransaction.class);

        setCustomerAccount(transferTransaction, createTransferTransactionDTO.getCustomerAccountID());

        return transferTransactionRepository.save(transferTransaction);
    }

    @Override
    public TransferTransaction updateById(Long id, UpdateTransferTransactionDTO updateTransactionDTO) {
        TransferTransaction transferTransaction = transferTransactionRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        modelMapper.map(updateTransactionDTO, transferTransaction);
        setCustomerAccount(transferTransaction, updateTransactionDTO.getCustomerAccountID());
        return transferTransaction;
    }

    @Override
    public void deleteById(Long id) {
        this.transferTransactionRepository.deleteById(id);
    }

    @Override
    public List<TransferTransaction> findAll() {
        return this.transferTransactionRepository.findAll();
    }

    @Override
    public TransferTransaction getById(Long id) {
        return this.transferTransactionRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Page<TransferTransaction> findAll(Pageable pageable) {
        return this.transferTransactionRepository.findAll(pageable);
    }
}
