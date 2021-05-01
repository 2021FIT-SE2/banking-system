package com.se2.bankingsystem.domains.CustomerAccount;

import com.se2.bankingsystem.domains.CustomerAccount.base.AbstractCustomerAccountRepository;
import com.se2.bankingsystem.domains.CustomerAccount.entity.CustomerAccount;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional(readOnly = true)
public interface CustomerAccountRepository extends AbstractCustomerAccountRepository<CustomerAccount> {
}
