package com.se2.bankingsystem.domains.Transaction.sub.WithdrawTransaction;

import com.se2.bankingsystem.config.exception.BankingSystemException;
import com.se2.bankingsystem.domains.CustomerAccount.CustomerAccountRepository;
import com.se2.bankingsystem.domains.CustomerAccount.behaviours.Withdrawable;
import com.se2.bankingsystem.domains.CustomerAccount.entity.CustomerAccount;
import com.se2.bankingsystem.domains.FakeEWallet.FakeEWalletRepository;
import com.se2.bankingsystem.domains.FakeEWallet.entity.FakeEWallet;
import com.se2.bankingsystem.domains.Transaction.base.AbstractTransactionServiceImpl;
import com.se2.bankingsystem.domains.Transaction.sub.WithdrawTransaction.dto.CreateWithdrawTransactionDTO;
import com.se2.bankingsystem.domains.Transaction.sub.WithdrawTransaction.dto.UpdateWithdrawTransactionDTO;
import com.se2.bankingsystem.domains.Transaction.sub.WithdrawTransaction.entity.WithdrawTransaction;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class WithdrawTransactionServiceImpl extends AbstractTransactionServiceImpl<WithdrawTransaction, CreateWithdrawTransactionDTO, UpdateWithdrawTransactionDTO> implements WithdrawTransactionService {

    private final FakeEWalletRepository fakeEWalletRepository;

    public WithdrawTransactionServiceImpl(CustomerAccountRepository customerAccountRepository, WithdrawTransactionRepository transactionRepository, ModelMapper modelMapper, FakeEWalletRepository fakeEWalletRepository) {
        super(customerAccountRepository, transactionRepository, modelMapper);
        this.fakeEWalletRepository = fakeEWalletRepository;
    }

    @Override
    public WithdrawTransaction create(CreateWithdrawTransactionDTO createWithdrawTransactionDTO) throws BankingSystemException {

        WithdrawTransaction withdrawTransaction = modelMapper.map(createWithdrawTransactionDTO, WithdrawTransaction.class);
        setCustomerAccount(withdrawTransaction, createWithdrawTransactionDTO.getCustomerAccountID());

        CustomerAccount customerAccount = withdrawTransaction.getCustomerAccount();

        if (!(customerAccount instanceof Withdrawable))
            throw new BankingSystemException("Account type not supported for withdraw transaction");

        FakeEWallet wallet = fakeEWalletRepository.findById(createWithdrawTransactionDTO.getWalletID()).orElseThrow(EntityNotFoundException::new);

        ((Withdrawable) customerAccount).withdraw(createWithdrawTransactionDTO.getWithdrawAmount());

        wallet.setBalance(wallet.getBalance() + createWithdrawTransactionDTO.getWithdrawAmount());

        withdrawTransaction.setWallet(wallet);

        fakeEWalletRepository.save(wallet);
        return abstractTransactionRepository.save(withdrawTransaction);
    }

    @Override
    public WithdrawTransaction updateById(Long id, UpdateWithdrawTransactionDTO updateTransactionDTO) {

        WithdrawTransaction transferTransaction = abstractTransactionRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        modelMapper.map(updateTransactionDTO, transferTransaction);

        setCustomerAccount(transferTransaction, updateTransactionDTO.getCustomerAccountID());
        return transferTransaction;
    }

    @Override
    public List<WithdrawTransaction> findAllByWalletId(Long walletId) {
        return ((WithdrawTransactionRepository) this.abstractTransactionRepository).findAllByWalletId(walletId);
    }
}
