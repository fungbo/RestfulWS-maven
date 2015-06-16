package com.tw.model;

import com.tw.Exception.AccountException;
import org.junit.Before;
import org.junit.Test;

import static com.tw.common.AccountMatcher.isAccount;
import static org.junit.Assert.assertThat;

public class AccountStorageTest {
    private AccountStorage storage;
    private Account mike;
    private Account jack;

    @Before
    public void setUp() {
        storage = new AccountStorage();
        mike = new Account("62001", 68.4);
        jack = new Account("62002", 0.07);
    }

    @Test
    public void should_be_able_to_add_and_get_account() throws AccountException {
        storage.add(mike);
        storage.add(jack);
        Account account = storage.get(jack.getMsisdn());

        assertThat(account, isAccount(new Account("62002", 0.07)));
    }

    @Test(expected = AccountException.class)
    public void should_throw_exception_when_add_existing_account() throws AccountException {
        storage.add(mike);
        storage.add(mike);
    }

    @Test(expected = AccountException.class)
    public void should_throw_exception_when_get_not_existing_account() throws AccountException {
        storage.get("InvalidMsisdn");
    }
}