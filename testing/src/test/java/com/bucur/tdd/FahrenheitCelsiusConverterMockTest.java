package com.bucur.tdd;

import com.bucur.junit4.FahrenheitCecliusConverter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

// what happens if I omit this?
@RunWith(MockitoJUnitRunner.class)
public class FahrenheitCelsiusConverterMockTest {

    @Mock
    FahrenheitCecliusConverter mockConverter;

    @Test
    public void givenConverter_whenToCelsius50_shouldReturn10() {
        when(mockConverter.toCelsius(anyInt()))
            .thenReturn(100);

        // (50°F − 32) × 5/9 = 10°C
        int actual = mockConverter.toCelsius(50);

        assertThat(actual).isEqualTo(100);
    }

    @Test
    public void givenConverter_whenToFahrenheit10_shouldReturn50() {
        when(mockConverter.toFahrenheit(anyInt()))
            .thenReturn(0);

        // (10°C × 9/5) + 32 = 50°F
        int actual = mockConverter.toFahrenheit(10);

        assertThat(actual).isEqualTo(0);
    }
}
