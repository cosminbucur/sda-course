package com.bucur.io.ex1;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Create a file with a "lorem ipsum" paragraph within it can be done by copy pasting
 * existing paragraph or generating it dynamically using Java library. Read that file.
 * a) Count words
 * b) * Count special signs like comma , dot , spaces
 * c) * Select one word and print it’s number of occurrences.
 */
public class DemoEx1 {

    // TODO: finish io
    public static void main(String[] args) {
        CustomeFileWriter fw = new CustomeFileWriter();
        fw.writeToFile(Paths.get("hello.txt"), 2, "hi");

        Path path = Paths.get("C:\\dev\\sda\\sda\\java-advanced\\src\\main\\resources\\readFile.txt");

        CustomeFileWriter customeFileWriter = new CustomeFileWriter();
        customeFileWriter.writeToFile(path, 3, "lorem ipsum");

        CustomFileReader customFileReader = new CustomFileReader();
        customFileReader.countWords(path);
    }
}
