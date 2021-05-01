package com.se2.bankingsystem.domains.CustomerAccount.sub.SavingAccount.entity;

import com.se2.bankingsystem.domains.CustomerAccount.behaviours.InterestRate;
import com.se2.bankingsystem.utils.NumberToWordConverter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;


@AllArgsConstructor
@Getter
public enum SavingDuration implements InterestRate {

    M1(3.5, 1),
    M2(3.5, 2),
    M3(3.8, 3),
    M6(4.4, 6),
    Y1(6.0, 12),
    Y2(6.0, 24),
    Y3(6.0, 36),
    ;

    private final double annualPercentageRate;
    private final int monthValue;

    @Override
    public double getInterestRate() {
        return this.getAnnualPercentageRate();
    }

    public String translation() {
        String ret = "";

        int value = 1;
        if (this.name().charAt(0) == 'M') {
            ret += " Month";
            if (this.monthValue > 1)
                ret += "s";
            value = monthValue;
        } else if (this.name().charAt(0) == 'Y') {
            ret += " Year";

            if (this.monthValue > 12)
                ret += "s";
            value = monthValue / 12;
        }
        String word = StringUtils.capitalize(NumberToWordConverter.convert(value));

        ret = word + " " + ret;
        return ret;
    }
}
