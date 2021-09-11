package com.sda.advanced.oop.abstraction;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DemoAbstractionTest {

    @Test
    void givenTwoShapes_whenArea_thenOk() {
        Shape shape1 = new Square("Red", 2);
        Shape shape2 = new Rectangle("Yellow", 2, 4);

        assertThat(shape1.area()).isEqualTo(4);
        assertThat(shape2.area()).isEqualTo(8);
    }
}