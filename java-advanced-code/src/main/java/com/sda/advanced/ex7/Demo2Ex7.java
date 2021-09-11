package com.sda.advanced.ex7;

import java.util.*;

public class Demo2Ex7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> itinerary = new HashMap<>();
        String line;

        System.out.println("Please enter country and city: ");

        // Read country and city until typing exit
        while (!(line = scanner.nextLine()).equals("exit")) {
            String[] splittedLine = line.split(" ");
            String country = splittedLine[0];
            String city = splittedLine[1];

            // check if the country has been already added
            if (itinerary.get(country) == null) {
                List<String> cities = new ArrayList<>();
                cities.add(city);
                itinerary.put(country, cities);
            } else {
                if (itinerary.get(country).contains(city)) {
                    itinerary.get(country).remove(city);
                    itinerary.get(country).add(city + " back and forth");
                } else {
                    itinerary.get(country).add(city);
                }
            }
        }

        // use utils method to write the map data to a json file
        JsonUtils.writeMapToJsonFile(itinerary, "itinerary.json");
    }

}
