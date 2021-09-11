package com.sda.advanced.exceptions.handlig;

import java.util.Scanner;

public class DemoTryWithResources {

    public static void main(String[] args) {
        System.out.println("Yo, type something in! ");

        regularTryCatch();

        tryWithResources();
    }

    private static void regularTryCatch() {
        Scanner scanner = null;

        try {
            scanner = new Scanner(System.in);
            System.out.println("Wow, you typed: \"" + scanner.next() + "\". You so smart...");
        } catch (Exception e) {
            // handle exception
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

        System.out.println(scanner.next()); // scanner.closed = false
    }

    private static void tryWithResources() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Wow, you typed: \"" + scanner.next() + "\". You so smart...");
        } catch (Exception e) {
            // handle exception
        }
        // no need to close scanner in finally
    }

}
