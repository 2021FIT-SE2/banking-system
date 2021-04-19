package com.se2.bankingsystem.domains.CustomerAccount.sub.SavingAccount;

import com.se2.bankingsystem.domains.CustomerAccount.sub.SavingAccount.entity.SavingAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavingAccountRepository extends JpaRepository<SavingAccount, Long> {
}
