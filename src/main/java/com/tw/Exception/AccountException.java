package com.tw.Exception;

public class AccountException extends Exception {
    private int code;
    private String uuidString;

    public AccountException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
