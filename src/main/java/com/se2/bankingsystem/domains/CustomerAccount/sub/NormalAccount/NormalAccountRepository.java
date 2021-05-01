package com.se2.bankingsystem.domains.CustomerAccount.sub.NormalAccount;

import com.se2.bankingsystem.domains.CustomerAccount.base.AbstractCustomerAccountRepository;
import com.se2.bankingsystem.domains.CustomerAccount.sub.NormalAccount.entity.NormalAccount;
import org.springframework.stereotype.Repository;

@Repository
public interface NormalAccountRepository extends AbstractCustomerAccountRepository<NormalAccount> {
}
