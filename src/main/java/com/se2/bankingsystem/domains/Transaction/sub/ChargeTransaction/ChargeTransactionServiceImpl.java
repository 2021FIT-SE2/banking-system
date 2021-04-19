package com.se2.bankingsystem.domains.Transaction.sub.ChargeTransaction;

import com.se2.bankingsystem.domains.CustomerAccount.CustomerAccountRepository;
import com.se2.bankingsystem.domains.CustomerAccount.entity.CustomerAccount;
import com.se2.bankingsystem.domains.Transaction.entity.Transaction;
import com.se2.bankingsystem.domains.Transaction.sub.ChargeTransaction.dto.CreateChargeTransactionDTO;
import com.se2.bankingsystem.domains.Transaction.sub.ChargeTransaction.dto.UpdateChargeTransactionDTO;
import com.se2.bankingsystem.domains.Transaction.sub.ChargeTransaction.entity.ChargeTransaction;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ChargeTransactionServiceImpl implements ChargeTransactionService {

    private final CustomerAccountRepository customerAccountRepository;

    private final ModelMapper modelMapper;

    private final ChargeTransactionRepository transferTransactionRepository;

    @Autowired
    public ChargeTransactionServiceImpl(ChargeTransactionRepository transferTransactionRepository, ModelMapper modelMapper, CustomerAccountRepository customerAccountRepository) {
        this.modelMapper = modelMapper;
        this.transferTransactionRepository = transferTransactionRepository;
        this.customerAccountRepository = customerAccountRepository;
    }

    public void setCustomerAccount(Transaction transaction, String customerAccountID) {
        CustomerAccount customerAccount = customerAccountRepository.findById(customerAccountID).orElseThrow(EntityNotFoundException::new);
        transaction.setCustomerAccount(customerAccount);
    }

    @Override
    public ChargeTransaction create(CreateChargeTransactionDTO createChargeTransactionDTO) {

        ChargeTransaction transferTransaction = modelMapper.map(createChargeTransactionDTO, ChargeTransaction.class);

        setCustomerAccount(transferTransaction, createChargeTransactionDTO.getCustomerAccountID());

        return transferTransactionRepository.save(transferTransaction);
    }

    @Override
    public ChargeTransaction updateById(Long id, UpdateChargeTransactionDTO updateTransactionDTO) {

        ChargeTransaction transferTransaction = transferTransactionRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        modelMapper.map(updateTransactionDTO, transferTransaction);

        setCustomerAccount(transferTransaction, updateTransactionDTO.getCustomerAccountID());

        return transferTransaction;
    }

    @Override
    public void deleteById(Long id) {
        this.transferTransactionRepository.deleteById(id);
    }

    @Override
    public List<ChargeTransaction> findAll() {
        return this.transferTransactionRepository.findAll();
    }

    @Override
    public ChargeTransaction getById(Long id) {
        return this.transferTransactionRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Page<ChargeTransaction> findAll(Pageable pageable) {
        return this.transferTransactionRepository.findAll(pageable);
    }
}
