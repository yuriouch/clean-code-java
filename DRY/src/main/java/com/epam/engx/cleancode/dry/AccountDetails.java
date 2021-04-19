package com.epam.engx.cleancode.dry;

import com.epam.engx.cleancode.dry.thirdpartyjar.Account;
import java.math.BigDecimal;
import java.util.Date;

public class AccountDetails implements Account {
    private Date birth;
    private int age;
    private BigDecimal balance;
    private Date startDate;

    @Override
    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Override
    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public int getAge() {
        return new InterestCalculator().durationBetweenDatesInYears(birth, new Date());       // should depend on current time
    }

    public void setAge(int age) {
        this.age = age;
    }

}
