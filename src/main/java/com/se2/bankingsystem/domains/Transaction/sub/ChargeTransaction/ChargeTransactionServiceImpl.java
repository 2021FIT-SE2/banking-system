package com.se2.bankingsystem.domains.Transaction.sub.ChargeTransaction;

import com.se2.bankingsystem.config.exception.BankingSystemException;
import com.se2.bankingsystem.domains.CustomerAccount.CustomerAccountRepository;
import com.se2.bankingsystem.domains.CustomerAccount.entity.CustomerAccount;
import com.se2.bankingsystem.domains.CustomerAccount.behaviours.Chargeable;
import com.se2.bankingsystem.domains.Transaction.base.AbstractTransactionServiceImpl;
import com.se2.bankingsystem.domains.Transaction.sub.ChargeTransaction.dto.CreateChargeTransactionDTO;
import com.se2.bankingsystem.domains.Transaction.sub.ChargeTransaction.dto.UpdateChargeTransactionDTO;
import com.se2.bankingsystem.domains.Transaction.sub.ChargeTransaction.entity.ChargeTransaction;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class ChargeTransactionServiceImpl extends AbstractTransactionServiceImpl<ChargeTransaction, CreateChargeTransactionDTO, UpdateChargeTransactionDTO> implements ChargeTransactionService {

    public ChargeTransactionServiceImpl(CustomerAccountRepository customerAccountRepository, ChargeTransactionRepository transactionRepository, ModelMapper modelMapper) {
        super(customerAccountRepository, transactionRepository, modelMapper);
    }

    @Override
    public ChargeTransaction create(CreateChargeTransactionDTO createChargeTransactionDTO) throws BankingSystemException {
        ChargeTransaction chargeTransaction = modelMapper.map(createChargeTransactionDTO, ChargeTransaction.class);
        setCustomerAccount(chargeTransaction, createChargeTransactionDTO.getCustomerAccountID());

        CustomerAccount customerAccount = chargeTransaction.getCustomerAccount();

        if (customerAccount instanceof Chargeable) {
            ((Chargeable) customerAccount).charge(chargeTransaction.getRedeemAmount());
            customerAccountRepository.save(customerAccount);
        } else {
            throw new BankingSystemException("Account type not supported for charge transaction");
        }
        return abstractTransactionRepository.save(chargeTransaction);
    }

    @Override
    public ChargeTransaction updateById(Long id, UpdateChargeTransactionDTO updateTransactionDTO) {
        ChargeTransaction transferTransaction = abstractTransactionRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        modelMapper.map(updateTransactionDTO, transferTransaction);
        setCustomerAccount(transferTransaction, updateTransactionDTO.getCustomerAccountID());
        return transferTransaction;
    }
}
