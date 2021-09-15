package com.sda.patterns.design.structural.decorator;

// TODO: 1. create interface with read/write operations
public interface DataSource {

    void writeData(String data);

    String readData();
}
