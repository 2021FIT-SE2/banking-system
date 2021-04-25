package com.se2.bankingsystem.domains.CustomerAccount.sub.LoanAccount;

import com.se2.bankingsystem.base.CRUDService;
import com.se2.bankingsystem.domains.Customer.entity.Customer;
import com.se2.bankingsystem.domains.CustomerAccount.sub.LoanAccount.dto.CreateLoanAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.sub.LoanAccount.dto.UpdateLoanAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.sub.LoanAccount.entity.LoanAccount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LoanAccountService extends CRUDService<LoanAccount, String, CreateLoanAccountDTO, UpdateLoanAccountDTO> {
    Page<LoanAccount> findAll(Pageable pageRequest);
}
