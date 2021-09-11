package com.sda.advanced.ex9;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

// https://github.com/mdeanda/lorem
public class DemoEx9 {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/home/cosmin/Documents/dev/sda/java-advanced-code/src/main/resources/ex9file.txt");
        String text = createDummyText();
//        writeToFile(path, text);
        Map<String, Integer> wordsMap = countWordsJava7(path);
        printStringMap(wordsMap);
    }

    public static String createDummyText() {
        Lorem lorem = LoremIpsum.getInstance();
        return lorem.getWords(5, 10);
    }

    public static void writeToFile(Path path, String content) {
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.printf("file saved.");
    }

    // https://www.leveluplunch.com/java/examples/count-distinct-word-occurrences-in-file/
    public static Map<String, Integer> countWordsJava7(Path path) throws IOException {
        List<String> lines = Files.readAllLines(path);

        Map<String, Integer> wordOccurrences = new HashMap<>();

        // for each line in file
        for (String line : lines) {

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

    public static void printStringMap(Map<String, Integer> map) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.printf("%s : %s %n", entry.getKey(), entry.getValue());
        }
    }

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
}
