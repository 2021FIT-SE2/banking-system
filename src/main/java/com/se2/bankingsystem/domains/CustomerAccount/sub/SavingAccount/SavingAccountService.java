package com.se2.bankingsystem.domains.CustomerAccount.sub.SavingAccount;

import com.se2.bankingsystem.domains.CustomerAccount.base.AbstractCustomerAccountService;
import com.se2.bankingsystem.domains.CustomerAccount.sub.SavingAccount.dto.CreateSavingAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.sub.SavingAccount.dto.UpdateSavingAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.sub.SavingAccount.entity.SavingAccount;
import org.springframework.scheduling.annotation.Scheduled;


public interface SavingAccountService extends AbstractCustomerAccountService<SavingAccount, CreateSavingAccountDTO, UpdateSavingAccountDTO> {
    @Scheduled(cron = "0 0 0 * * ?")
    void increaseSavingOnEveryday();
}
