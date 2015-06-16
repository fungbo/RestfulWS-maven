package com.tw.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class AccountResponse {
    private enum Status {
        SUCCESS, FAILURE
    }

    private Status status;
    private int code;
    private String message;

    public static AccountResponse getSuccessfulInstance() {
        return new AccountResponse(Status.SUCCESS, 0);
    }

    public static AccountResponse getFailInstance(int code, String message) {
        return new AccountResponse(Status.FAILURE, code);
    }

    private AccountResponse(Status status, int code) {
        this.status = status;
        this.code = code;
    }

    public Status getStatus() {
        return status;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
