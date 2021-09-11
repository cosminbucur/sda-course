package com.sda.testing.junit5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

// https://www.arhohuttunen.com/junit-5-parameterized-tests/#what-about-null-values
class Junit5ParameterizedTest {

    private static Stream<Arguments> numberToMonth() {
        return Stream.of(
                Arguments.arguments(1, "Jan"),
                Arguments.arguments(6, "Jun"),
                Arguments.arguments(12, "Dec")
        );
    }

    // multiple values
    @ParameterizedTest
    @ValueSource(ints = {3, 6, 15, -9})
    void shouldBeDivisibleByThree(int number) {
        assertThat(UtilityClass.isDivisibleByThree(number)).isTrue();
    }

    // null and empty
    @ParameterizedTest
    @EmptySource
    @NullSource
    @ValueSource(strings = {" "})
    void shouldReturnTrueForNullEmptyAndBlankStrings(String text) {
        assertThat(text == null || text.trim().isEmpty()).isTrue();
    }

    // enum
    @ParameterizedTest
    @EnumSource(
            value = Day.class,
            names = {"SATURDAY", "SUNDAY"}
    )
    void shouldBeWeekend(Day day) {
        assertThat(MyCalendar.isWeekend(day)).isTrue();
    }

    // multiple arguments
    @ParameterizedTest
    @MethodSource("numberToMonth")
    void shouldReturnMonthName(int monthNumber, String monthName) {
        assertThat(MyCalendar.getMonthName(monthNumber)).isEqualTo(monthName);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/shopping.csv")
    void readShoppingList(String item, Integer price) {
        assertThat(price <= 50).isTrue();
        System.out.println(item + " = " + price);
    }

}
