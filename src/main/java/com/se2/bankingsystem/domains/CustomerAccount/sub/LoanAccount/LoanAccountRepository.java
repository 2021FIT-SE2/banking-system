package com.se2.bankingsystem.domains.CustomerAccount.sub.LoanAccount;

import com.se2.bankingsystem.domains.CustomerAccount.base.AbstractCustomerAccountRepository;
import com.se2.bankingsystem.domains.CustomerAccount.sub.LoanAccount.entity.LoanAccount;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanAccountRepository extends AbstractCustomerAccountRepository<LoanAccount> {

}
