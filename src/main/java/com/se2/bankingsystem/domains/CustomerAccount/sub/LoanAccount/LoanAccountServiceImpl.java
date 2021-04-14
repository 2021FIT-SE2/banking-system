package com.se2.bankingsystem.domains.CustomerAccount.sub.LoanAccount;

import com.se2.bankingsystem.domains.CustomerAccount.sub.LoanAccount.dto.CreateLoanAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.sub.LoanAccount.dto.UpdateLoanAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.sub.LoanAccount.entity.LoanAccount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanAccountServiceImpl implements LoanAccountService {
    @Override
    public LoanAccount create(CreateLoanAccountDTO modelType) {
        return null;
    }

    @Override
    public LoanAccount updateById(Long id, UpdateLoanAccountDTO modelType) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<LoanAccount> findAll() {
        return null;
    }

    @Override
    public LoanAccount getById(Long id) {
        return null;
    }

    @Override
    public Page<LoanAccount> findAll(Pageable pageable) {
        return null;
    }
}
