package com.sda.advanced.io.how;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class DemoWordCount3 {

    public static void main(String[] args) {
        Path source = Paths.get("C:\\dev\\sda\\sda\\java-advanced\\src\\main\\resources\\readFile.txt");
        long readWordsCount = countWordsJava8(source);
        System.out.println(readWordsCount);
    }

    private static long countWordsJava8(Path path) {
        long readWordsCount = 0;
        try (Stream<String> lines = Files.lines(path)) {
            readWordsCount = lines.flatMap(line -> Arrays.stream(line.trim()
                .split("[ ,.!?\\r\\n]")))   // split by new line
                .count();
        } catch (IOException e) {
            System.out.println("could not read file");
        }
        return readWordsCount;
    }
}
