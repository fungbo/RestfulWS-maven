package com.tw.controller;

import com.tw.Exception.AccountException;
import com.tw.common.Constants;
import com.tw.common.JsonUtils;
import com.tw.model.*;
import com.tw.service.AccountStorage;
import com.tw.service.HttpServcie;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    private static Logger LOGGER = Logger.getLogger(AccountController.class);
    @Autowired
    private AccountStorage storage;
    @Autowired
    private HttpServcie httpService;

    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    public AccountResponse addAccount(@RequestBody Account account) throws AccountException {
        LOGGER.debug("[" + account.getUuidString() + "] Add account:\n" + JsonUtils.marshal(account));
        storage.add(account);
        AccountResponse response = AccountResponse.getSuccessfulInstance();
        LOGGER.debug("[" + account.getUuidString() + "] Response:\n" + JsonUtils.marshal(response));
        return response;
    }

    @RequestMapping(value = "get/{msisdn}", method = RequestMethod.GET)
    public Account getAccount(@PathVariable("msisdn") String msisdn) throws AccountException {
        LOGGER.debug("Get account msisdn: " + msisdn);
        return storage.get(msisdn);
    }

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public Collection<Account> getAllAccounts() {
        LOGGER.debug("Get all accounts");
        return storage.getAll();
    }

    @RequestMapping(method = RequestMethod.GET)
    public Account getAccountByMsisdn(@RequestParam String msisdn, @RequestParam(required = false) Account.Type type) throws AccountException {
        LOGGER.debug("Get account by http get param");
        return storage.get(msisdn);
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public AccountResponse updateAccount(@RequestBody Account account) throws AccountException {
        LOGGER.debug("Update account:\n" + JsonUtils.marshal(account));
        storage.update(account);
        AccountResponse response = AccountResponse.getSuccessfulInstance();
        LOGGER.debug("Response:\n" + JsonUtils.marshal(response));
        return response;
    }

    @RequestMapping(value = "all", method = RequestMethod.DELETE)
    public AccountResponse removeAll() {
        LOGGER.debug("Delete all accounts.");
        storage.removeAll();
        return AccountResponse.getSuccessfulInstance();
    }

    @RequestMapping(value = "httpbin", method = RequestMethod.GET)
    public HttpInfo getHttpInfo() throws AccountException {
        HttpInfo httpInfo = httpService.getHttpInfo();
        return httpInfo;
    }

    @RequestMapping(value = "get-customer", method = RequestMethod.GET)
    public Customer getMtsms() {
        List<Object> customer = new ArrayList<Object>();
        Address address = new Address();
        address.setCity("xian");
        address.setStreet("jinye");
        PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.setNumber("001");
        phoneNumber.setType("prpd");

        customer.add(address);
        customer.add(phoneNumber);
        customer.add("rick@gmail.com");

        Customer mtsmsData = new Customer();
        mtsmsData.setCustomerInfo(customer);

        return mtsmsData;
    }

    @ExceptionHandler(value = HttpMessageConversionException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public AccountResponse handleUnmarshalException(HttpMessageConversionException e) {
        AccountResponse response = AccountResponse.getFailInstance(Constants.WRONG_FORMAT, e.getCause().getMessage());
        LOGGER.error("Response:\n" + JsonUtils.marshal(response));
        return response;
    }

    @ExceptionHandler(value = AccountException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public AccountResponse handleAccountException(AccountException e) {
        AccountResponse response = AccountResponse.getFailInstance(e.getCode(), e.getMessage());
        LOGGER.error("Response:\n" + JsonUtils.marshal(response));
        return response;
    }
}
