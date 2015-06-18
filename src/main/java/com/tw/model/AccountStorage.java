package com.tw.model;

import com.tw.Exception.AccountException;
import com.tw.common.Constants;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

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

    public Collection<Account> getAll() {
        return storage.values();
    }

    public Account update(Account newAccount) throws AccountException {
        return updateObject(get(newAccount.getMsisdn()), newAccount);
    }

    private boolean isAccountExisting(String msisdn) {
        return storage.get(msisdn) != null;
    }

    private <T> T updateObject(T oldObj, T newObj) {
        Field[] fields = Account.class.getDeclaredFields();
        try {
            for (Field field : fields) {
                if (field.getType() != UUID.class) {
                    field.setAccessible(true);
                    field.set(oldObj, getUpdatedField(field.get(oldObj), field.get(newObj)));
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Update account error");
        }
        return oldObj;
    }

    private <T> T getUpdatedField(T oldItem, T newItem) {
        return newItem != null ? newItem : oldItem;
    }
}
