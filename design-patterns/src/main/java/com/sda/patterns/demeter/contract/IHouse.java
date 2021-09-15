package com.sda.patterns.demeter.contract;

public interface IHouse {

    IAddress getAddress();

    String getColor();

    Double getSize();

    String getZipCode();
}
