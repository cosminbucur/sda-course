package com.bucur.junit5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

// https://www.baeldung.com/parameterized-tests-junit-5
class NumbersTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, -3, 15, Integer.MAX_VALUE})
        // six numbers
    void isOdd_shouldReturnTrueForOddNumbers(int number) {
        assertThat(Numbers.isOdd(number)).isTrue();
    }
}