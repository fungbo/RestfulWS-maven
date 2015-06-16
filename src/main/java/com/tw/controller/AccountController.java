package com.tw.controller;

import com.tw.Exception.AccountException;
import com.tw.common.Constants;
import com.tw.common.JsonMarshaller;
import com.tw.model.Account;
import com.tw.model.AccountResponse;
import com.tw.model.AccountStorage;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {
    private static Logger LOGGER = Logger.getLogger(AccountController.class);
    @Autowired
    private AccountStorage storage;

    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    public AccountResponse addAccount(@RequestBody Account account) throws AccountException {
        LOGGER.debug("[" + account.getUuidString() + "] Add account:\n" + JsonMarshaller.marshal(account));
        storage.add(account);
        AccountResponse response = AccountResponse.getSuccessfulInstance();
        LOGGER.debug("[" + account.getUuidString() + "] Response:\n" + JsonMarshaller.marshal(response));
        return response;
    }

    @ExceptionHandler(value = HttpMessageConversionException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public AccountResponse handleUnmarshalException(HttpMessageConversionException e) {
        AccountResponse response = AccountResponse.getFailInstance(Constants.WRONG_FORMAT, e.getCause().getMessage());
        LOGGER.error("Response:\n" + JsonMarshaller.marshal(response));
        return response;
    }

    @ExceptionHandler(value = AccountException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public AccountResponse handleAccountException(AccountException e) {
        AccountResponse response = AccountResponse.getFailInstance(e.getCode(), e.getMessage());
        LOGGER.error("Response:\n" + JsonMarshaller.marshal(response));
        return response;
    }
}

