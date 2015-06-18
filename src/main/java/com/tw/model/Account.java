package com.tw.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.UUID;

public class Account {
    public enum Type {
        PRPD("PREPAID"), POPD("POSTPAID");

        private String name;

        Type(String name) {
            this.name = name;
        }

        @JsonCreator
        public static Type fromName(String name) {
            for (Type type : Type.values()) {
                if (type.name.equals(name)) {
                    return type;
                }
            }
            return null;
        }

        public String getName() {
            return name;
        }

    }

    private UUID uuid = UUID.randomUUID();

    private Type type;
    private String msisdn;
    private double balance;

    public Account(Type type, String msisdn, double balance) {
        this.type = type;
        this.msisdn = msisdn;
        this.balance = balance;
    }

    public Account() {

    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @JsonIgnore
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
