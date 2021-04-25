package com.se2.bankingsystem.domains.CustomerAccount.sub.LoanAccount;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class LoanAccountScheduledTasks {

    private final LoanAccountService loanAccountService;

    @Scheduled
    public void increaseLoan() {

    }
}
