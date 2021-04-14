package com.se2.bankingsystem.domains.CustomerAccount.sub.SavingAccount;

import com.se2.bankingsystem.domains.CustomerAccount.sub.SavingAccount.dto.CreateSavingAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.sub.SavingAccount.dto.UpdateSavingAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.sub.SavingAccount.entity.SavingAccount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SavingAccountServiceImpl implements SavingAccountService {
    @Override
    public SavingAccount create(CreateSavingAccountDTO modelType) {
        return null;
    }

    @Override
    public SavingAccount updateById(Long id, UpdateSavingAccountDTO modelType) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<SavingAccount> findAll() {
        return null;
    }

    @Override
    public SavingAccount getById(Long id) {
        return null;
    }

    @Override
    public Page<SavingAccount> findAll(Pageable pageable) {
        return null;
    }
}
