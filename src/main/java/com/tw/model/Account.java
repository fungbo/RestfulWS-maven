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
    private Double balance;

    public Account(Type type, String msisdn, Double balance) {
        this.type = type;
        this.msisdn = msisdn;
        this.balance = balance;
    }

    public Account() {
    }

    @JsonIgnore
    public String getUuidString() {
        return uuid.toString();
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Account:{");
        sb.append("type:").append(type).append(",");
        sb.append("msisdn:").append(msisdn).append(",");
        sb.append("balance:").append(balance).append("}");
        return sb.toString();
    }
}
