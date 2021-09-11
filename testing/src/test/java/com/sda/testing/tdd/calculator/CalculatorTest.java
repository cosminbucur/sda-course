package com.sda.testing.tdd.calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class CalculatorTest {

    @Test
    void shouldReturnZeroOnEmptyString() {
        assertThat(Calculator.add("")).isEqualTo(0);
    }

    @Test
    void shouldReturnNumberOnNumber() {
        assertThat(Calculator.add("1")).isEqualTo(1);
    }

    @Test
    void shouldReturnSumOnTwoNumbersDelimitedByComma() {
        assertThat(Calculator.add("1,2")).isEqualTo(3);
    }

    @Test
    void shouldReturnSumOnMultipleNumbers() {
        assertThat(Calculator.add("1,2,3")).isEqualTo(6);
    }

    @Test
    void shouldAcceptNewLineAsValidDelimiter() {
        assertThat(Calculator.add("1,2\n3")).isEqualTo(6);
    }

    @Test
    void shouldRaiseExceptionOnNegatives() {
        Throwable exception = catchThrowable(() ->
                Calculator.add("-1,2,3"));

        assertThat(exception)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("negative number not supported");
    }

    @Test
    void exceptionMessageShouldContainTheNegativeNumber() {
        Throwable exception = catchThrowable(() ->
                Calculator.add("-1,-2,3"));

        assertThat(exception)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("negative number not supported: -1,-2");
    }
}
