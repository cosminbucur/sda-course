package com.sda.patterns.demeter.contract;

public interface IAddress {

    String getZipCode();

    String getNumber();

    String getStreet();

    String getCity();

    String getState();

    String getCounty();
}
