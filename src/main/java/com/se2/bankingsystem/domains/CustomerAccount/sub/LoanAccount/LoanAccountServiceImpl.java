package com.se2.bankingsystem.domains.CustomerAccount.sub.LoanAccount;

import com.se2.bankingsystem.domains.Customer.CustomerRepository;
import com.se2.bankingsystem.domains.Customer.entity.Customer;
import com.se2.bankingsystem.domains.CustomerAccount.sub.LoanAccount.dto.CreateLoanAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.sub.LoanAccount.dto.UpdateLoanAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.sub.LoanAccount.entity.LoanAccount;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@AllArgsConstructor
public class LoanAccountServiceImpl implements LoanAccountService {

    private final LoanAccountRepository loanAccountRepository;
    private final ModelMapper modelMapper;
    private final CustomerRepository customerRepository;

    @Override
    public LoanAccount create(CreateLoanAccountDTO createLoanAccountDTO) {
        LoanAccount loanAccount = modelMapper.map(createLoanAccountDTO, LoanAccount.class);
        loanAccount.setCurrentLoan(loanAccount.getPrincipal());

        Customer customer = customerRepository.findById(createLoanAccountDTO.getCustomerID()).orElseThrow(EntityNotFoundException::new);
        loanAccount.setCustomer(customer);

        return loanAccountRepository.save(loanAccount);
    }

    @Override
    public LoanAccount updateById(String id, UpdateLoanAccountDTO updateLoanAccountDTO) {
        LoanAccount existing = loanAccountRepository.findById(id).orElseThrow(EntityExistsException::new);
        modelMapper.map(updateLoanAccountDTO, existing);
        return loanAccountRepository.save(existing);
    }

    @Override
    public void deleteById(String id) {
        loanAccountRepository.deleteById(id);
    }

    @Override
    public List<LoanAccount> findAll() {
        return loanAccountRepository.findAll();
    }

    @Override
    public LoanAccount getById(String id) {
        return loanAccountRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Page<LoanAccount> findAll(Pageable pageable) {
        return loanAccountRepository.findAll(pageable);
    }
}
