package com.se2.bankingsystem.domains.Transaction.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TransactionType {
    CHARGE(Constants.CHARGE_VALUE),
    TRANSFER(Constants.TRANSFER_VALUE),
    WITHDRAW(Constants.WITHDRAW_VALUE),
    ;

    private final String value;

    public static class Constants {
        public static final String CHARGE_VALUE = "CHARGE";
        public static final String TRANSFER_VALUE = "TRANSFER";
        public static final String WITHDRAW_VALUE = "WITHDRAW";
    }
}
