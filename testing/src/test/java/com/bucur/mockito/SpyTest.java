package com.bucur.mockito;

import com.bucur.junit4.Calculator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class SpyTest {

    @Test
    public void spyTest() {
        // given
        Calculator calculator = new Calculator();
        Calculator spyCalculator = spy(calculator);
        when(spyCalculator.add(eq(4), eq(6))).thenReturn(55);

        // when
        // use breakpoints to see that the real method is called
        int actual = spyCalculator.add(4, 6);

        // then
        assertEquals(55, actual);
    }

    @Test
    public void spyTest2() {
        // given
        Calculator calculator = new Calculator();
        Calculator spyCalculator = spy(calculator);

        // when
        spyCalculator.add(2, 5);

        // then
        verify(spyCalculator).add(anyInt(), anyInt());
    }
}
