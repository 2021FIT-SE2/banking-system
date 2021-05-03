package com.se2.bankingsystem.domains.CustomerAccount.behaviours;

import com.se2.bankingsystem.config.exception.BankingSystemException;

import javax.validation.constraints.Positive;

public interface Withdrawable {
    void withdraw(@Positive Long amount) throws BankingSystemException;
}
