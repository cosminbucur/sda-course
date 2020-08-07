package com.bucur.jvm;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * HelloWorld class used to test jdk tools.
 */
public class HelloWorld {

    public static void main(String[] args) {
        System.out.println("Hello, World!");

        String firstArgument = args[0];
        String secondArgument = args[1];
        try {
            divide(Integer.parseInt(firstArgument), Integer.parseInt(secondArgument));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Sums two integers.
     *
     * @param a first operand
     * @param b second operand
     * @return the sum of the operands
     * @throws IOException if a file is not found
     */
    public static int divide(int a, int b) throws IOException {
        Path path = Paths.get("C:\\dev\\sda\\sda\\jvm\\src\\main\\resources\\sample.txt");
        List<String> lines = Files.readAllLines(path);
        lines.forEach(line -> System.out.println(line));

        return a / b;
    }
}
