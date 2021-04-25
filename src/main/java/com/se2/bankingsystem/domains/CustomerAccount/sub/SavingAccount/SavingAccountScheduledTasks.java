package com.se2.bankingsystem.domains.CustomerAccount.sub.SavingAccount;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class SavingAccountScheduledTasks {

    private final SavingAccountService savingAccountService;

    @Scheduled
    public void increaseSaving() {

    }
}
