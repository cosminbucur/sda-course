package com.bucur.junit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class PrimeNumberCheckerTest {

    private Integer inputNumber;
    private Boolean expectedResult;
    private PrimeNumberChecker primeNumberChecker;

    public PrimeNumberCheckerTest(Integer inputNumber, Boolean expectedResult) {
        this.inputNumber = inputNumber;
        this.expectedResult = expectedResult;
    }

    // Each parameter should be placed as an argument here
    // Every time runner triggers, it will pass the arguments
    // from parameters we defined in primeNumbers() method

    @Parameterized.Parameters
    public static List<Object[]> primeNumbers() {
        Object[][] combinations = {
            {2, true},
            {6, false},
            {19, true},
            {22, false},
            {23, true}
        };
        return Arrays.asList(combinations);
    }

    @Before
    public void initialize() {
        primeNumberChecker = new PrimeNumberChecker();
    }

    // This test will run 4 times since we have 5 parameters defined
    @Test
    public void testPrimeNumberChecker() {
        System.out.println("Parameterized Number is : " + inputNumber);
        assertEquals(expectedResult,
            primeNumberChecker.validate(inputNumber));
    }
}
