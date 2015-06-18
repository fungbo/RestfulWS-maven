package com.tw.common;

import com.tw.model.Account;
import com.tw.model.AccountResponse;

import java.util.List;

public class Matchers {
    public static AccountMatcher isAccount(Account expectedAccount) {
        return new AccountMatcher(expectedAccount);
    }

    public static AllAccountMatcher isAccount(List<Account> expectedAccount) {
        return new AllAccountMatcher(expectedAccount);
    }

    public static AccountResponseMatcher isAccountResponse(AccountResponse expectedResponse) {
        return new AccountResponseMatcher(expectedResponse);
    }

    public static boolean isAccountMatch(Account actualAccount, Account expectedAccount) {
        return expectedAccount.getMsisdn().equals(actualAccount.getMsisdn())
                && expectedAccount.getBalance().compareTo(actualAccount.getBalance()) == 0;
    }

}
