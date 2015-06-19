package com.tw.model;

import com.tw.Exception.AccountException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static com.tw.common.Matchers.isAccount;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class AccountStorageTest {
    private AccountStorage storage;
    private Account mike;
    private Account jack;

    @Parameterized.Parameter
    public String actualMsisdn;
    @Parameterized.Parameter(value = 1)
    public Account expectedAccount;

    @Parameterized.Parameters(name = "{index}: expected msisdn: <{0}>")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"62001", new Account(Account.Type.PRPD, "62001", 68.4)},
                {"62002", new Account(Account.Type.POPD, "62002", 0.07)}
        });
    }

    @Before
    public void setUp() {
        storage = new AccountStorage();
        mike = new Account(Account.Type.PRPD, "62001", 68.4);
        jack = new Account(Account.Type.POPD, "62002", 0.07);
    }

    @Test
    public void should_be_able_to_add_and_get_account() throws AccountException {
        storage.add(mike);
        storage.add(jack);

        assertThat(storage.get(actualMsisdn), isAccount(expectedAccount));
    }

    @Test
    public void should_get_all_accounts() throws AccountException {
        storage.add(mike);
        storage.add(jack);
        Account[] accounts = storage.getAll().toArray(new Account[storage.getAll().size()]);
        List<Account> actualAccounts = Arrays.asList(accounts);

        ArrayList<Account> expectedAccounts = new ArrayList<Account>();
        expectedAccounts.add(mike);
        expectedAccounts.add(jack);

        assertThat(actualAccounts, isAccount(expectedAccounts));
    }

    @Test
    public void should_update_account() throws AccountException {
        storage.add(mike);
        storage.add(jack);
        Account account = new Account();
        account.setMsisdn(mike.getMsisdn());
        account.setBalance(8.0);
        storage.update(account);

        assertThat(storage.get(mike.getMsisdn()), isAccount(new Account(Account.Type.PRPD, "62001", 8.0)));
    }

    @Test
    public void should_remove_all_accounts() throws AccountException {
        storage.add(mike);
        storage.add(jack);
        storage.removeAll();
        Collection<Account> allAccounts = storage.getAll();

        assertThat(allAccounts.size(), is(0));
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
