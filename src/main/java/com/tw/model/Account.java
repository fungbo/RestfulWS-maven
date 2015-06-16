package com.tw.model;

public class Account {
    private String msisdn;
    private double balance;

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
