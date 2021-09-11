package com.sda.advanced.homebank.model;

import java.math.BigDecimal;

public class Account {

    private String owner;
    private BigDecimal balance;

    public Account(String owner, BigDecimal balance) {
        this.owner = owner;
        this.balance = balance;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
            "owner='" + owner + '\'' +
            ", balance=" + balance +
            '}';
    }
}
