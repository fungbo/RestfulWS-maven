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
        return new AccountResponse(Status.SUCCESS, 0, null);
    }

    public static AccountResponse getFailInstance(int code, String message) {
        return new AccountResponse(Status.FAILURE, code, message);
    }

    private AccountResponse(Status status, int code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
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
