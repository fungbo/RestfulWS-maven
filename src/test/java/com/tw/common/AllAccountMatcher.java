package com.tw.common;

import com.tw.model.Account;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

import java.util.List;

public class AllAccountMatcher extends TypeSafeMatcher<List<Account>> {
    private List<Account> expectedAccounts;

    public AllAccountMatcher(List<Account> expectedAccounts) {
        this.expectedAccounts = expectedAccounts;
    }

    @Override
    protected boolean matchesSafely(List<Account> actualAccounts) {
        if (actualAccounts.size() != expectedAccounts.size()) {
            return false;
        }

        for (int i = 0; i < actualAccounts.size(); i++) {
            if (!Matchers.isAccountMatch(actualAccounts.get(i), expectedAccounts.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void describeTo(Description description) {
        description.appendValue(expectedAccounts.toString());
    }

    @Override
    protected void describeMismatchSafely(List<Account> actualAccounts, Description mismatchDescription) {
        mismatchDescription.appendValue(actualAccounts.toString());
    }
}
