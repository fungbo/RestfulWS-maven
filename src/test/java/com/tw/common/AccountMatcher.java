package com.tw.common;

import com.tw.model.Account;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class AccountMatcher extends TypeSafeMatcher<Account> {

    private Account expectedAccount;

    public static AccountMatcher isAccount(Account expectedAccount) {
        return new AccountMatcher(expectedAccount);
    }

    public AccountMatcher(Account expectedAccount) {
        this.expectedAccount = expectedAccount;
    }

    @Override
    protected boolean matchesSafely(Account actualAccount) {
        return expectedAccount.getMsisdn().equals(actualAccount.getMsisdn())
                && Double.compare(expectedAccount.getBalance(), actualAccount.getBalance()) == 0;
    }

    @Override
    protected void describeMismatchSafely(Account actualAccount, Description mismatchDescription) {
        mismatchDescription.appendValue(actualAccount.toString());
    }

    public void describeTo(Description description) {
        description.appendValue(expectedAccount.toString());
    }
}
