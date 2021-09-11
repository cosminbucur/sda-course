package com.sda.advanced.optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class DemoOptionalTest {

    @Test
    void optionalOrElse() {
        Optional<String> name = Optional.of("Alex");

        assertThat(name.orElse("")).isEqualTo("Alex");
    }

    @Test
    void orElse() {
        Optional<String> name = Optional.empty();

        assertThat(name.orElse("")).isEqualTo("");
    }

    @Test
    void givenNamePresent_whenOrElseThrow_shouldReturnOk() {
        Optional<String> name = Optional.of("Alex");

        assertThat(name.orElseThrow(() -> new IllegalArgumentException("name not found")))
                .isEqualTo("Alex");
    }

    @Test
    void givenEmptyOptional_whenOrElseThrow_shouldThrowException() {
        Optional<String> name = Optional.empty();

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> name.orElseThrow(IllegalArgumentException::new));
    }
}