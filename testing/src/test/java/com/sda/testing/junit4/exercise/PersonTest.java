package com.sda.testing.junit4.exercise;

import com.sda.testing.tdd.Person;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonTest {

    @Test
    public void whenAge10_shouldReturnFalse() {
        Person person = new Person(10);

        boolean actual = person.isTeenager();

        assertThat(actual).isTrue();
    }

    @Test
    public void whenAge11_shouldReturnTrue() {
        Person person = new Person(11);

        boolean actual = person.isTeenager();

        assertThat(actual).isTrue();
    }

    @Test
    public void whenAge20_shouldReturnTrue() {
        Person person = new Person(20);

        boolean actual = person.isTeenager();

        assertThat(actual).isFalse();
    }
}
