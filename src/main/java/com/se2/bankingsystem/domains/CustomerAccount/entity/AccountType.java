package com.se2.bankingsystem.domains.CustomerAccount.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AccountType {
    LOAN(Constants.LOAN_VALUE),
    NORMAL(Constants.NORMAL_VALUE),
    SAVING(Constants.SAVING_VALUE),
    ;

    private final String value;

    public static class Constants {
        public static final String LOAN_VALUE = "LOAN";
        public static final String NORMAL_VALUE = "NORMAL";
        public static final String SAVING_VALUE = "SAVING";
    }
}
