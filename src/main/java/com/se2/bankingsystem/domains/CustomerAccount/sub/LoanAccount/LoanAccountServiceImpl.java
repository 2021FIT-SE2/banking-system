package com.se2.bankingsystem.domains.CustomerAccount.sub.LoanAccount;

import com.se2.bankingsystem.domains.CustomerAccount.sub.LoanAccount.dto.CreateLoanAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.sub.LoanAccount.dto.UpdateLoanAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.sub.LoanAccount.entity.LoanAccount;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class LoanAccountServiceImpl implements LoanAccountService {

    private final LoanAccountRepository loanAccountRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public LoanAccountServiceImpl(LoanAccountRepository loanAccountRepository, ModelMapper modelMapper) {
        this.loanAccountRepository = loanAccountRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public LoanAccount create(CreateLoanAccountDTO createLoanAccountDTO) {
        LoanAccount loanAccount = modelMapper.map(createLoanAccountDTO, LoanAccount.class);
        return loanAccountRepository.save(loanAccount);
    }

    @Override
    public LoanAccount updateById(Long id, UpdateLoanAccountDTO updateLoanAccountDTO) {
        LoanAccount existing = loanAccountRepository.findById(id).orElseThrow(EntityExistsException::new);
        modelMapper.map(updateLoanAccountDTO, existing);
        return loanAccountRepository.save(existing);
    }

    @Override
    public void deleteById(Long id) {
        loanAccountRepository.deleteById(id);
    }

    @Override
    public List<LoanAccount> findAll() {
        return loanAccountRepository.findAll();
    }

    @Override
    public LoanAccount getById(Long id) {
        return loanAccountRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Page<LoanAccount> findAll(Pageable pageable) {
        return loanAccountRepository.findAll(pageable);
    }
}
