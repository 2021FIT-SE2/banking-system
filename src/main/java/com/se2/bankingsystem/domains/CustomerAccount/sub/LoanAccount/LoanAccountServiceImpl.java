package com.se2.bankingsystem.domains.CustomerAccount.sub.LoanAccount;

import com.se2.bankingsystem.domains.Customer.CustomerRepository;
import com.se2.bankingsystem.domains.CustomerAccount.base.AbstractCustomerAccountServiceImpl;
import com.se2.bankingsystem.domains.CustomerAccount.sub.LoanAccount.dto.CreateLoanAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.sub.LoanAccount.dto.UpdateLoanAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.sub.LoanAccount.entity.LoanAccount;

import org.modelmapper.ModelMapper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service

public class LoanAccountServiceImpl extends AbstractCustomerAccountServiceImpl<LoanAccount, CreateLoanAccountDTO, UpdateLoanAccountDTO> implements LoanAccountService {

    public LoanAccountServiceImpl(CustomerRepository customerRepository, LoanAccountRepository abstractCustomerAccountRepository, ModelMapper modelMapper) {
        super(customerRepository, abstractCustomerAccountRepository, modelMapper, LoanAccount.class);
    }

    @Override
    public LoanAccount create(CreateLoanAccountDTO createCustomerAccountDTO) {
        LoanAccount loanAccount = convertToCustomerAccount(createCustomerAccountDTO);

        loanAccount.setCurrentLoan(loanAccount.getPrincipal());

        return abstractCustomerAccountRepository.save(loanAccount);
    }

    @Scheduled(cron = "0 0 0 * * ?")
    @Override
    public void increaseLoanOnEveryDay() {

    }
}
