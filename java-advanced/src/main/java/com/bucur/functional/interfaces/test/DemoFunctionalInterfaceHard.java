package com.bucur.functional.interfaces.test;

import java.io.IOException;
import java.io.OutputStream;

public class DemoFunctionalInterfaceHard {

    public static void main(String[] args) {
        interfacesWithDefaultAndStaticMethods();

        anonymousInterfaceImplementation();
    }

    private static void interfacesWithDefaultAndStaticMethods() {
        Printable printable = (String text) -> {
            System.out.println(text);
        };
        printable.printIt("print it");
        printable.printUtf8To("print utf8", new OutputStream() {
            @Override
            public void write(int b) throws IOException {
                System.out.println("writing to output stream");
            }
        });
    }

    private static void anonymousInterfaceImplementation() {
        EventConsumer consumer = new EventConsumer() {
            private int eventCount = 0;

            @Override
            public void consume(Object event) {
                System.out.println(event.toString() + " consumed" +
                    this.eventCount++ + " times.");
            }
        };
        consumer.consume(new Object());
    }
}

