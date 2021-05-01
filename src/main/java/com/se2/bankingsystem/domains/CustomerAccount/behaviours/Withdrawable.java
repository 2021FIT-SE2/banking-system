package com.se2.bankingsystem.domains.CustomerAccount.behaviours;

import com.se2.bankingsystem.config.exception.BankingSystemException;

import javax.validation.constraints.PositiveOrZero;

public interface Withdrawable {
    void withdraw(@PositiveOrZero Long amount) throws BankingSystemException;
}
