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
    private static final int YEAR = 1;

    public BigDecimal calculateInterest(AccountDetails accountDetails) {
        if (isAccountStartedAfterBonusAge(accountDetails)) {
            return calculateSimpleInterest(accountDetails);
        } else {
            return BigDecimal.ZERO;
        }
    }

    private boolean isAccountStartedAfterBonusAge(AccountDetails accountDetails) {
        return durationBetweenDatesInYears(
                accountDetails.getBirth(),
                accountDetails.getStartDate()) > BONUS_AGE;
    }

    private BigDecimal calculateSimpleInterest(AccountDetails accountDetails) {
        double simpleInterest;
        if (accountDetails.getAge() >= AGE) {
            simpleInterest = getAccountBalance(accountDetails) *
                    getDurationInYears(accountDetails) *  SENIOR_PERCENT / 100;
        } else {
            simpleInterest = getAccountBalance(accountDetails) *
                    getDurationInYears(accountDetails) * INTEREST_PERCENT / 100;
        }
        return BigDecimal.valueOf(simpleInterest);
    }

    public int durationBetweenDatesInYears(Date startDate, Date endDate) {
        Calendar startCalendar = getCalendar(startDate);
        Calendar endCalendar = getCalendar(endDate);

        int durationInYears = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
        if (hasExcessYear(startCalendar, endCalendar)) {
            return durationInYears - YEAR;
        }
        return durationInYears;
    }

    private Calendar getCalendar(Date date) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        return calendar;
    }

    private boolean hasExcessYear(Calendar startCalendar, Calendar endCalendar) {
        return endCalendar.get(Calendar.DAY_OF_YEAR) + LEAP_YEAR_SHIFT
                < startCalendar.get(Calendar.DAY_OF_YEAR);
    }

    private double getAccountBalance(AccountDetails accountDetails) {
        return accountDetails.getBalance().doubleValue();
    }

    private double getDurationInYears(AccountDetails accountDetails) {
        return durationBetweenDatesInYears(accountDetails.getStartDate(), new Date());
    }
}
