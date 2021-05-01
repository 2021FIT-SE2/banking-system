package com.se2.bankingsystem.config.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class BankingSystemException extends Exception {
    public BankingSystemException(String message) {
        super(message);
    }
}
