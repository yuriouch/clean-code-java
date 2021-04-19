package com.epam.engx.cleancode.dry;

import com.epam.engx.cleancode.dry.thirdpartyjar.Profitable;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class InterestCalculator implements Profitable {

    private static final int AGE = 60;
    private static final BigDecimal INTEREST_PERCENT = BigDecimal.valueOf(4.5d);
    private static final BigDecimal SENIOR_PERCENT = BigDecimal.valueOf(5.5d);
    private static final int BONUS_AGE = 13;
    private static final int LEAP_YEAR_SHIFT = 1;


    public BigDecimal calculateInterest(AccountDetails accountDetails) {
        if (!isAccountStartedAfterBonusAge(accountDetails)) {
            return BigDecimal.ZERO;
        }

        if (accountDetails.getAge() >= AGE) {
            return interest(accountDetails, SENIOR_PERCENT);
        } else {
            return interest(accountDetails, INTEREST_PERCENT);
        }
    }

    private boolean isAccountStartedAfterBonusAge(AccountDetails accountDetails) {
        return durationBetweenDatesInYears(
                accountDetails.getBirth(),
                accountDetails.getStartDate()) > BONUS_AGE;
    }

    private int durationBetweenDatesInYears(Date from, Date to) {
        Calendar startCalendar = new GregorianCalendar();
        startCalendar.setTime(from);
        Calendar endCalendar = new GregorianCalendar();
        endCalendar.setTime(to);

        int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
        if (endCalendar.get(Calendar.DAY_OF_YEAR) + LEAP_YEAR_SHIFT
                < startCalendar.get(Calendar.DAY_OF_YEAR)) {
            return diffYear - 1;
        }
        return diffYear;
    }

    private BigDecimal interest(AccountDetails accountDetails, BigDecimal annualInterestRate) {
        double duration = durationBetweenDatesInYears(accountDetails.getStartDate(), new Date());

        //interest = (PrincipalAmount * DurationInYears * AnnualInterestRate) / 100
        return accountDetails
                .getBalance()
                .multiply(BigDecimal.valueOf(duration))
                .multiply(annualInterestRate)
                .divide(BigDecimal.valueOf(100));
    }
}
