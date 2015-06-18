package com.tw.common;

import com.tw.model.Account;

import java.util.List;

public class Matchers {
    public static AccountMatcher isAccount(Account expectedAccount) {
        return new AccountMatcher(expectedAccount);
    }

    public static AllAccountMatcher isAccount(List<Account> expectedAccount) {
        return new AllAccountMatcher(expectedAccount);
    }

    static boolean isAccountMatch(Account actualAccount, Account expectedAccount) {
        return expectedAccount.getMsisdn().equals(actualAccount.getMsisdn())
                && Double.compare(expectedAccount.getBalance(), actualAccount.getBalance()) == 0;
    }
}
