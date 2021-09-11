package com.sda.advanced.functional.interfaces.test;

import java.io.IOException;
import java.io.OutputStream;

public interface Printable {

    static void printItToConsole(String text) {
        System.out.println(text);
    }

    void printIt(String text);

    default void printUtf8To(String text, OutputStream outputStream) {
        try {
            outputStream.write(text.getBytes("UTF-8"));
        } catch (IOException e) {
            throw new RuntimeException("Error writing String as UTF-8 to OutputStream", e);
        }
    }
}
