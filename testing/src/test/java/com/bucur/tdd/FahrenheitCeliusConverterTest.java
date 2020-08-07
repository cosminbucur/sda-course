package com.bucur.tdd;

import com.bucur.junit4.FahrenheitCecliusConverter;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FahrenheitCeliusConverterTest {

    @Test
    public void givenConverter_whenToCelsius50_shouldReturn10() {
        FahrenheitCecliusConverter converter = new FahrenheitCecliusConverter();

        // (50°F − 32) × 5/9 = 10°C
        int actual = converter.toCelsius(50);

        assertThat(actual).isEqualTo(10);
    }

    @Test
    public void givenConverter_whenToFahrenheit10_shouldReturn50() {
        FahrenheitCecliusConverter converter = new FahrenheitCecliusConverter();

        // (10°C × 9/5) + 32 = 50°F
        int actual = converter.toFahrenheit(10);

        assertThat(actual).isEqualTo(50);
    }
}
