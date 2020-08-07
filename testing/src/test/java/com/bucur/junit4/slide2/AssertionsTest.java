package com.bucur.junit4.slide2;

import org.junit.Test;

import static org.junit.Assert.*;

public class AssertionsTest {

    @Test
    public void assertionTest() {
        int[] array1 = {1, 2};
        int[] array2 = {1, 2};
        String nullString = null;
        String one = "text";
        String two = "text";

        assertEquals(64, 2 * 32);
        assertNotEquals("values are not equal", 1, 2);
        assertTrue(true);
        assertFalse(false);
        assertArrayEquals(array1, array2);
        assertArrayEquals(array1, array2);
        assertNull(nullString);
        assertSame(one, two);
    }
}
