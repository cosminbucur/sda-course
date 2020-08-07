package com.bucur.io.ex1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CustomeFileWriter {

    public void writeToFile(Path path, int lineCount, String line) {
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (int i = 0; i < lineCount; i++) {
                writer.write(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.printf("written line '%s' %d times to file %n", line, lineCount);
    }
}
