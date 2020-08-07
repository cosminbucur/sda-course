package com.bucur.junit4;

public class FahrenheitCecliusConverter {

    public int toCelsius(int fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public int toFahrenheit(int celsius) {
        return (celsius * 9 / 5) + 32;
    }
}
