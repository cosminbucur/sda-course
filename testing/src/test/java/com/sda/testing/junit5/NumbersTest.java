package com.sda.testing.junit5;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumbersTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, -3, 15, Integer.MAX_VALUE})
        // six numbers
    void isOdd_shouldReturnTrueForOddNumbers(int number) {
        Assertions.assertThat(Numbers.isOdd(number)).isTrue();
    }
}