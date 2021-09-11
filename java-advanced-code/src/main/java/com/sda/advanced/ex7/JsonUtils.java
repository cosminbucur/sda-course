package com.sda.advanced.ex7;

import java.util.List;
import java.util.Map;

//import org.json.JSONArray;
//import org.json.JSONObject;

public class JsonUtils {


    public static void writeMapToJsonFile(Map<String, List<String>> itinerary, String filename) {
        // create Json objects
//        JSONObject itineraryJson = new JSONObject();
//        JSONArray countriesJson = new JSONArray();
//
//        for (Map.Entry<String, List<String>> entry : itinerary.entrySet()) {
//            JSONObject countryCitiesJson = new JSONObject();
//            countryCitiesJson.put("country", entry.getKey());
//            countryCitiesJson.put("cities", new JSONArray(entry.getValue()));
//
//            countriesJson.put(countryCitiesJson);
//        }
//
//        itineraryJson.put("countries", countriesJson);
//
//        // write the final json to a filename
//        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
//            bw.write(itineraryJson.toString());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public static void getMapFromJson() {
        // use JSONParser
    }
}