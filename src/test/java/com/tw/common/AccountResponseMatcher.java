package com.tw.common;

import com.tw.model.AccountResponse;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class AccountResponseMatcher extends TypeSafeMatcher<AccountResponse> {

    private AccountResponse expectedResponse;

    public AccountResponseMatcher(AccountResponse expectedResponse) {
        this.expectedResponse = expectedResponse;
    }

    @Override
    protected boolean matchesSafely(AccountResponse actualResponse) {
        return expectedResponse.getStatus() == actualResponse.getStatus()
                && expectedResponse.getCode() == actualResponse.getCode()
                && isMessageEqual(actualResponse);
    }

    @Override
    protected void describeMismatchSafely(AccountResponse actualResponse, Description mismatchDescription) {
        mismatchDescription.appendValue(actualResponse);
    }

    @Override
    public void describeTo(Description description) {
        description.appendValue(expectedResponse.toString());
    }

    private boolean isMessageEqual(AccountResponse actualResponse) {
        return expectedResponse.getMessage() != null ?
                expectedResponse.getMessage().equals(actualResponse.getMessage())
                : expectedResponse.getMessage() == actualResponse.getMessage();
    }
}
