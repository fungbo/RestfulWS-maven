package com.tw.Exception;

public class AccountException extends Exception {
    private int code;

    public AccountException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
