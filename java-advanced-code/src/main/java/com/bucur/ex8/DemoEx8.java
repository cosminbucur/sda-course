package com.bucur.ex8;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DemoEx8 {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/home/cosmin/Documents/dev/sda/java-advanced-code/src/main/resources/itinerary.txt");
        Map<String, List<String>> itinerary = readJsonFromFile(path);
        printMapOfList(itinerary);

        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        switch (input) {
            case "next":
                System.out.println("next item selected");
                break;
            case "q":
                System.out.println("bye");
                System.exit(0);
                break;
            default:
                System.out.println("invalid input: q = quit, next = next country");
        }
    }

    public static Map<String, List<String>> readJsonFromFile(Path path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        byte[] mapData = Files.readAllBytes(path);
        Map<String, List<String>> map;
        map = objectMapper.readValue(mapData, HashMap.class);
        return map;
    }

    public static void printMapOfList(Map<String, List<String>> map) {
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            System.out.println("---");
            System.out.printf("%s : %n", entry.getKey());
            printList(entry.getValue());
        }
    }

    public static void printList(List<String> list) {
        list.forEach(item -> System.out.println(item + " "));
    }

}
