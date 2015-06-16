package com.tw.model;

import java.util.UUID;

public class Account {
    private UUID uuid = UUID.randomUUID();
    private String msisdn;
    private double balance;

    public Account(String msisdn, double balance) {
        this.msisdn = msisdn;
        this.balance = balance;
    }

    public Account() {

    }

    public String getUuidString() {
        return uuid.toString();
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Account:{");
        sb.append("msisdn:").append(msisdn).append(",");
        sb.append("balance:").append(balance).append("}");
        return sb.toString();
    }
}
