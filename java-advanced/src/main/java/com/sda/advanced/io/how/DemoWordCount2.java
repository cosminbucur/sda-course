package com.sda.advanced.io.how;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DemoWordCount2 {

    public static void main(String[] args) throws IOException {
        System.out.println(countWordsJava8(Paths.get("C:\\dev\\sda\\sda\\java-advanced\\src\\main\\resources\\people.txt")));
    }

    public static Map<String, Integer> countWordsJava8(Path path) throws IOException {
        List<String> lines = Files.readAllLines(path);

        Map<String, Integer> wordOccurrences = new HashMap<>();

//        lines.stream()
//                .map(line -> extract)

        // for each line in file
        for (String line : lines) {

            // to get an array of words, split the line string by empty spaces
            String[] words = line.split(" ");

            // for every word in file
            for (String word : words) {

                word = word.replace(".", "");

                if (!word.trim().isEmpty()) {
                    if (wordOccurrences.containsKey(word)) {
                        int count = wordOccurrences.get(word).intValue();
                        wordOccurrences.put(word, new Integer(count + 1));
                    } else {
                        wordOccurrences.put(word, new Integer(1));
                    }
                }
            }
        }
        return wordOccurrences;
    }

//    private static String[] convertLineToWords(List<String> lines) {
//        List<String> words = lines.stream()
//                .map(line -> line.split(" "))
//                .collect(Collectors.toList());
//
//    }
}
