package com.sda.advanced.ex7;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DemoEx7 {

    // FIXME: improve it
    public static void main(String[] args) {
        List<String> cities1 = new ArrayList<>();
        cities1.add("bucharest");
        cities1.add("cluj");

        List<String> cities2 = new ArrayList<>();
        cities2.add("zurich");
        cities2.add("bern");

        Map<String, List<String>> itineraryMap = new HashMap<>();
        itineraryMap.put("romania", cities1);
        itineraryMap.put("switzerland", cities2);
        printMapOfList(itineraryMap);

        String itinerary = convertMapToJson(itineraryMap);

        Path path = Paths.get("/home/cosmin/Documents/dev/sda/java-advanced-code/src/main/resources/itinerary.txt");
        writeToFile(path, itinerary);
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

    public static String convertMapToJson(Map<String, List<String>> map) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        String json = "{}";
        try {
            json = objectMapper.writeValueAsString(map);
            System.out.println("json = " + json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

    public static void writeToFile(Path path, String content) {
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.printf("file saved.");
    }
}
