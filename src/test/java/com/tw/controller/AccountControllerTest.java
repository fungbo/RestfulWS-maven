package com.tw.controller;

import com.tw.Exception.AccountException;
import com.tw.common.JsonUtils;
import com.tw.model.Account;
import com.tw.model.AccountResponse;
import com.tw.model.HttpInfo;
import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static com.tw.common.Matchers.isAccount;
import static com.tw.common.Matchers.isAccountResponse;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring-test.xml"})
public class AccountControllerTest {
    @Autowired
    private AccountController controller;
    private Account mike;
    private Account jack;


    @Before
    public void setUp() {
        mike = new Account(Account.Type.PRPD, "62001", 68.4);
        jack = new Account(Account.Type.POPD, "62002", 0.07);
    }

    @Test
    public void should_get_successful_response_after_removing_all_accounts() {
        assertThat(controller.removeAll(), isAccountResponse(AccountResponse.getSuccessfulInstance()));
    }

    @Test
    public void should_get_successful_response_after_adding_account() throws AccountException {
        controller.removeAll();

        assertThat(controller.addAccount(mike), isAccountResponse(AccountResponse.getSuccessfulInstance()));
    }

    @Test
    public void should_get_account() throws AccountException {
        controller.removeAll();
        controller.addAccount(mike);
        controller.addAccount(jack);
        Account account = controller.getAccount(jack.getMsisdn());

        assertThat(account, isAccount(new Account(Account.Type.POPD, "62002", 0.07)));
    }

    @Test
    public void should_get_all_accounts() throws AccountException {
        controller.removeAll();
        controller.addAccount(mike);
        controller.addAccount(jack);
        Collection<Account> allAccounts = controller.getAllAccounts();
        List<Account> actualAccounts = Arrays.asList(allAccounts.toArray(new Account[allAccounts.size()]));

        ArrayList<Account> expectedAccounts = new ArrayList<Account>();
        expectedAccounts.add(new Account(Account.Type.PRPD, "62001", 68.4));
        expectedAccounts.add(new Account(Account.Type.POPD, "62002", 0.07));

        assertThat(actualAccounts, isAccount(expectedAccounts));
    }

    @Test
    public void should_get_successful_response_after_updating_account() throws AccountException {
        controller.removeAll();
        controller.addAccount(mike);
        Account account = new Account();
        account.setMsisdn(mike.getMsisdn());
        account.setType(Account.Type.POPD);
        account.setBalance(0.45);
        AccountResponse response = controller.updateAccount(account);

        assertThat(response, isAccountResponse(AccountResponse.getSuccessfulInstance()));
    }

    @Test(timeout = 5000)
    @Ignore
    public void should_get_httpbin() throws AccountException, IOException {
        String expectedInfo = IOUtils.toString(Thread.currentThread().getContextClassLoader().getResourceAsStream("http-info-test.json"));
        HttpInfo httpInfo = controller.getHttpInfo();
        String actualInfo = JsonUtils.marshal(httpInfo);

        assertThat(actualInfo, is(expectedInfo));
    }
}
