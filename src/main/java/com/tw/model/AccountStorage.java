package com.tw.model;

import com.tw.common.Constants;
import com.tw.Exception.AccountException;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class AccountStorage {
    private HashMap<String, Account> storage = new HashMap<String, Account>();

    public Account add(Account account) throws AccountException {
        if (isAccountExisting(account.getMsisdn())) {
            throw new AccountException(Constants.MSISDN_EXISTING, "Account you added is existing");
        }
        return storage.put(account.getMsisdn(), account);
    }

    public Account get(String msisdn) throws AccountException {
        if (!isAccountExisting(msisdn)) {
            throw new AccountException(Constants.MSISDN_NOT_EXISTING, "Account you got is not existing");
        }
        return storage.get(msisdn);
    }

    private boolean isAccountExisting(String msisdn) {
        return storage.get(msisdn) != null;
    }
}
