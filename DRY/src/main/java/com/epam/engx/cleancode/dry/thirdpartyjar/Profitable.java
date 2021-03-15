package com.epam.engx.cleancode.dry.thirdpartyjar;

import com.epam.engx.cleancode.dry.AccountDetails;

import java.math.BigDecimal;

public interface Profitable {
    BigDecimal calculateInterest(AccountDetails accountDetails);
}
