package com.bucur.functional.optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class DemoOptionalTest {

    @Test
    public void optionalOrElse() {
        Optional<String> name = Optional.of("Alex");

        assertThat(name.orElse("")).isEqualTo("Alex");
    }

    @Test
    public void orElse() {
        Optional<String> name = Optional.empty();

        assertThat(name.orElse("")).isEqualTo("");
    }

    @Test
    public void givenNamePresent_whenOrElseThrow_shouldReturnOk() {
        Optional<String> name = Optional.of("Alex");

        assertThat(name.orElseThrow(() -> new IllegalArgumentException("name not found")))
            .isEqualTo("Alex");
    }

    @Test
    public void givenEmptyOptional_whenOrElseThrow_shouldThrowException() {
        Optional<String> name = Optional.empty();

        Assertions.assertThrows(IllegalArgumentException.class,
            () -> name.orElseThrow(IllegalArgumentException::new));
    }

    @Test
    public void givenEmptyOptional_whenOrElseThrow_shouldThrowException1() {
        Optional<String> name = Optional.of("Alex");

        name.ifPresent(myName -> myName.toUpperCase());
    }

}