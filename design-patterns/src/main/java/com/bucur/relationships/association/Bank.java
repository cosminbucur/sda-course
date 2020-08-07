package com.bucur.relationships.association;

public class Bank {
    private String name;

    Bank(String name) {
        this.name = name;
    }

    public String getBankName() {
        return this.name;
    }
}