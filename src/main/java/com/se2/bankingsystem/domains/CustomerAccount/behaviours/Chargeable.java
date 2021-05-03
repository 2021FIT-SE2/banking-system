package com.se2.bankingsystem.domains.CustomerAccount.behaviours;

import com.se2.bankingsystem.config.exception.BankingSystemException;

import javax.validation.constraints.Positive;

public interface Chargeable {
    void charge(@Positive Long amount) throws BankingSystemException;
}
