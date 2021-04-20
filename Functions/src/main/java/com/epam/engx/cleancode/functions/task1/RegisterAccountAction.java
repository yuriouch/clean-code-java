package com.epam.engx.cleancode.functions.task1;

import com.epam.engx.cleancode.functions.task1.thirdpartyjar.*;
import static com.epam.engx.cleancode.functions.task1.thirdpartyjar.CheckStatus.OK;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RegisterAccountAction {

    private PasswordChecker passwordChecker;
    private AccountManager accountManager;
    private final int MIN_NAME_LENGTH = 5;
    private final int MIN_PASSWORD_LENGTH = 8;

    public void register(Account account) {
        validateAccountName(account.getName());
        checkPasswordLength(account.getPassword());
        checkPasswordStatus(account.getPassword());
        prepareAccountToRegister(account);
        accountManager.createNewAccount(account);
    }

    private void validateAccountName(String name) {
        if (name.length() <= MIN_NAME_LENGTH){
            throw new WrongAccountNameException();
        }
    }

    private void checkPasswordLength(String password) {
        if (password.length() <= MIN_PASSWORD_LENGTH) {
            throw new TooShortPasswordException();
        }
    }

    private void checkPasswordStatus(String password) {
        if (passwordChecker.validate(password) != OK) {
            throw new WrongPasswordException();
        }
    }

    private void prepareAccountToRegister(Account account) {
        List<Address> addresses = new ArrayList<Address>();
        addresses.add(account.getHomeAddress());
        addresses.add(account.getWorkAddress());
        addresses.add(account.getAdditionalAddress());
        account.setAddresses(addresses);
        account.setCreatedDate(new Date());
    }

    public void setAccountManager(AccountManager accountManager) {
        this.accountManager = accountManager;
    }

    public void setPasswordChecker(PasswordChecker passwordChecker) {
        this.passwordChecker = passwordChecker;
    }
}
