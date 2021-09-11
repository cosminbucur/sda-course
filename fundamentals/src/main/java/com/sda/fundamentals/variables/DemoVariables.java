package com.sda.fundamentals.variables;

// data containers
public class DemoVariables {

    // declare variable
    int x;

    // initialize variable
    int y = 1;

    public static void main(String[] args) {
        // --- integer types

        // 1 byte - 128 to 127  | default 0
        byte aByte = 127;

        // 2 bytes -32768 to 32767  | default 0
        short aShort = 32767;

        // 4 bytes -2147483648 to 2147483647 | default 0
        int anInteger = 2147483647;

        // 8 bytes -2^63 to 2^63 | default 0L
        long along = 1612546047L;

        // --- floating points types
        float aFloat = 10.1234567f;

        // 8 bytes 15 decimals
        double aDouble = 20.5;

        // --- logical type
        // default false
        boolean aBoolean = true;

        // default ''
        char tab = 'a';

        // default null
        String someText = "java code";

        // null - denotes the absence of something
    }

}
