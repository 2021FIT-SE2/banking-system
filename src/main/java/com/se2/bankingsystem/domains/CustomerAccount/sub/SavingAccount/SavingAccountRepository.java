package com.se2.bankingsystem.domains.CustomerAccount.sub.SavingAccount;

import com.se2.bankingsystem.domains.CustomerAccount.base.AbstractCustomerAccountRepository;
import com.se2.bankingsystem.domains.CustomerAccount.sub.SavingAccount.entity.SavingAccount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SavingAccountRepository extends AbstractCustomerAccountRepository<SavingAccount> {
    @Query("SELECT s FROM SavingAccount s WHERE s.savingDuration < :now")
    List<SavingAccount> findAllThatNeedsSavingIncrease(LocalDateTime now);
}
