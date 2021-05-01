package com.se2.bankingsystem.domains.Transaction.sub.WithdrawTransaction;

import com.se2.bankingsystem.domains.CustomerAccount.CustomerAccountRepository;
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
    public WithdrawTransaction create(CreateWithdrawTransactionDTO createWithdrawTransactionDTO) {

        WithdrawTransaction withdrawTransaction = modelMapper.map(createWithdrawTransactionDTO, WithdrawTransaction.class);
        setCustomerAccount(withdrawTransaction, createWithdrawTransactionDTO.getCustomerAccountID());

        FakeEWallet fakeEWallet = fakeEWalletRepository.findById(createWithdrawTransactionDTO.getWalletID()).orElseThrow(EntityNotFoundException::new);
        withdrawTransaction.setWallet(fakeEWallet);

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
