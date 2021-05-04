package com.se2.bankingsystem.domains.Transaction.sub.ChargeTransaction;

import com.se2.bankingsystem.config.exception.BankingSystemException;
import com.se2.bankingsystem.domains.Authority.AuthorityService;
import com.se2.bankingsystem.domains.Authority.entity.AuthorityName;
import com.se2.bankingsystem.domains.CustomerAccount.CustomerAccountRepository;
import com.se2.bankingsystem.domains.CustomerAccount.behaviours.Chargeable;
import com.se2.bankingsystem.domains.CustomerAccount.entity.CustomerAccount;
import com.se2.bankingsystem.domains.FakeEWallet.FakeEWalletRepository;
import com.se2.bankingsystem.domains.FakeEWallet.entity.FakeEWallet;
import com.se2.bankingsystem.domains.Transaction.base.AbstractTransactionServiceImpl;
import com.se2.bankingsystem.domains.Transaction.sub.ChargeTransaction.dto.CreateChargeTransactionDTO;
import com.se2.bankingsystem.domains.Transaction.sub.ChargeTransaction.dto.UpdateChargeTransactionDTO;
import com.se2.bankingsystem.domains.Transaction.sub.ChargeTransaction.entity.ChargeTransaction;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class ChargeTransactionServiceImpl extends AbstractTransactionServiceImpl<ChargeTransaction, CreateChargeTransactionDTO, UpdateChargeTransactionDTO> implements ChargeTransactionService {

    private final FakeEWalletRepository fakeEWalletRepository;
    private final AuthorityService authorityService;

    public ChargeTransactionServiceImpl(CustomerAccountRepository customerAccountRepository, ChargeTransactionRepository transactionRepository, ModelMapper modelMapper, FakeEWalletRepository fakeEWalletRepository, AuthorityService authorityService) {
        super(customerAccountRepository, transactionRepository, modelMapper);
        this.fakeEWalletRepository = fakeEWalletRepository;
        this.authorityService = authorityService;
    }

    @Override
    public ChargeTransaction create(CreateChargeTransactionDTO createChargeTransactionDTO) throws BankingSystemException {
        ChargeTransaction chargeTransaction = modelMapper.map(createChargeTransactionDTO, ChargeTransaction.class);
        super.setCustomerAccount(chargeTransaction, createChargeTransactionDTO.getCustomerAccountID());

        CustomerAccount customerAccount = chargeTransaction.getCustomerAccount();

        if (customerAccount instanceof Chargeable) {

            // If this charge transaction was made by a customer
            // Then the field createChargeTransactionDTO.walletID is required

            // With the walletID, find the wallet and withdraw from it
            if (authorityService.getCurrentAuthority().equals(AuthorityName.CUSTOMER.name())) {
                FakeEWallet wallet = fakeEWalletRepository.findById(createChargeTransactionDTO.getWalletID()).orElseThrow(EntityNotFoundException::new);

                if (createChargeTransactionDTO.getRedeemAmount() > wallet.getBalance())
                    throw new BankingSystemException("Redeem amount is bigger than current wallet's balance");

                wallet.setBalance(wallet.getBalance() - createChargeTransactionDTO.getRedeemAmount());
                wallet = fakeEWalletRepository.save(wallet);
                chargeTransaction.setWallet(wallet);
            }

            ((Chargeable) customerAccount).charge(chargeTransaction.getRedeemAmount());

            customerAccountRepository.save(customerAccount);
        } else {
            throw new BankingSystemException("Account type not supported for charge transaction");
        }
        return abstractTransactionRepository.save(chargeTransaction);
    }

    @Override
    public ChargeTransaction updateById(Long id, UpdateChargeTransactionDTO updateTransactionDTO) throws BankingSystemException {
        ChargeTransaction chargeTransaction = abstractTransactionRepository.findById(id).orElseThrow(() -> new BankingSystemException("Charge Transaction not Found"));
        modelMapper.map(updateTransactionDTO, chargeTransaction);
        super.setCustomerAccount(chargeTransaction, updateTransactionDTO.getCustomerAccountID());
        return chargeTransaction;
    }
}
