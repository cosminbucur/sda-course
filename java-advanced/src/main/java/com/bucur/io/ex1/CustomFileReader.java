package com.bucur.io.ex1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.Stream;

public class CustomFileReader {

    public long countWords(Path path) {
        long count = 0;
        try {
            Stream<String> lines = Files.lines(path);
            count = lines.flatMap(line -> Arrays.stream(line.trim().split(" ")))
                .count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("number of words = " + count);

        return count;
    }

    public long countSpecialSigns(Path path) {
        long count = 0;
        try {
            Stream<String> lines = Files.lines(path);
            count = lines.flatMap(line -> Arrays.stream(line.trim().split(" ")))
                .count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("number of words = " + count);

        return count;
    }
}
