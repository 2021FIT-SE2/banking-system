package com.se2.bankingsystem.domains.Transaction.sub.ChargeTransaction;

import com.se2.bankingsystem.domains.CustomerAccount.CustomerAccountRepository;
import com.se2.bankingsystem.domains.Transaction.TransactionRepository;
import com.se2.bankingsystem.domains.Transaction.TransactionServiceImpl;
import com.se2.bankingsystem.domains.Transaction.dto.CreateTransactionDTO;
import com.se2.bankingsystem.domains.Transaction.dto.UpdateTransactionDTO;
import com.se2.bankingsystem.domains.Transaction.sub.ChargeTransaction.dto.CreateChargeTransactionDTO;
import com.se2.bankingsystem.domains.Transaction.sub.ChargeTransaction.entity.ChargeTransaction;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;


@Service
public class ChargeTransactionServiceImpl extends TransactionServiceImpl<ChargeTransaction> implements ChargeTransactionService {

    protected ChargeTransactionServiceImpl(TransactionRepository<ChargeTransaction> transactionRepository, ModelMapper modelMapper, CustomerAccountRepository customerAccountRepository) {
        super(transactionRepository, modelMapper, customerAccountRepository);
    }

    @Override
    public ChargeTransaction create(CreateChargeTransactionDTO createChargeTransactionDTO) {
        ChargeTransaction chargeTransaction = modelMapper.map(createChargeTransactionDTO, ChargeTransaction.class);
        setCustomerAccount(chargeTransaction, createChargeTransactionDTO.getCustomerAccountID());
        return transactionRepository.save(chargeTransaction);
    }

    @Override
    public ChargeTransaction updateById(Long id, UpdateTransactionDTO updateTransactionDTO) {
        ChargeTransaction chargeTransaction = transactionRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        modelMapper.map(updateTransactionDTO, chargeTransaction);
        return chargeTransaction;
    }
}
