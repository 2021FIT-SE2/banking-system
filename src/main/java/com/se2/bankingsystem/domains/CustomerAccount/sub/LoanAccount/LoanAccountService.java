package com.se2.bankingsystem.domains.CustomerAccount.sub.LoanAccount;

import com.se2.bankingsystem.base.CRUDService;
import com.se2.bankingsystem.domains.CustomerAccount.sub.LoanAccount.dto.CreateLoanAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.sub.LoanAccount.dto.UpdateLoanAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.sub.LoanAccount.entity.LoanAccount;

public interface LoanAccountService extends CRUDService<LoanAccount, Long, CreateLoanAccountDTO, UpdateLoanAccountDTO> {
}
