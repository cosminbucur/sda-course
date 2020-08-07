package com.bucur.oop.abstraction;

//import org.junit.Test;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DemoAbstractionTest {

    @Test
    public void givenTwoShapes_whenArea_thenOk() {
        Shape shape1 = new Square("Red", 2);
        Shape shape2 = new Rectangle("Yellow", 2, 4);

        assertThat(shape1.area()).isEqualTo(4);
        assertThat(shape2.area()).isEqualTo(8);
    }
}