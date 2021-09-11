package com.sda.testing.tdd.converter;

public class FahrenheitCelsiusConverter {

    public int toCelsius(int fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public int toFahrenheit(int celsius) {
        return (celsius * 9 / 5) + 32;
    }
}
