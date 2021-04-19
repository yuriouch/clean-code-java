package com.epam.engx.cleancode.dry;

import com.epam.engx.cleancode.dry.thirdpartyjar.Profitable;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class InterestCalculator implements Profitable {

    private static final int AGE = 60;
    private static final double INTEREST_PERCENT = 4.5d;
    private static final double SENIOR_PERCENT = 5.5d;
    private static final int BONUS_AGE = 13;
    private static final int LEAP_YEAR_SHIFT = 1;


    public BigDecimal calculateInterest(AccountDetails accountDetails) {
        if (isAccountStartedAfterBonusAge(accountDetails)) {
            double interestRate = chooseInterestRate(accountDetails);
            return calculateSimpleInterest(accountDetails, interestRate);
        } else {
            return BigDecimal.ZERO;
        }
    }

    private boolean isAccountStartedAfterBonusAge(AccountDetails accountDetails) {
        return durationBetweenDatesInYears(
                accountDetails.getBirth(),
                accountDetails.getStartDate()) > BONUS_AGE;
    }

     public int durationBetweenDatesInYears(Date startDate, Date endDate) {
        Calendar startCalendar = new GregorianCalendar();
        startCalendar.setTime(startDate);
        Calendar endCalendar = new GregorianCalendar();
        endCalendar.setTime(endDate);

        int durationInYears = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
        if (endCalendar.get(Calendar.DAY_OF_YEAR) + LEAP_YEAR_SHIFT
                < startCalendar.get(Calendar.DAY_OF_YEAR)) {
            return durationInYears - 1;
        }
        return durationInYears;
    }

    private double chooseInterestRate(AccountDetails accountDetails) {
        if (accountDetails.getAge() >= AGE) {
            return SENIOR_PERCENT;
        } else {
            return INTEREST_PERCENT;
        }
    }

    private BigDecimal calculateSimpleInterest(AccountDetails accountDetails, double interestRate) {
        double durationInYears = durationBetweenDatesInYears(accountDetails.getStartDate(), new Date());
        double accountBalance = accountDetails.getBalance().doubleValue();
        //interest = (PrincipalAmount * DurationInYears * AnnualInterestRate) / 100
        double simpleInterest = accountBalance * durationInYears * interestRate / 100;
        return BigDecimal.valueOf(simpleInterest);
    }
}
