package com.sda.advanced.collections.map.ex1;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DemoEx1 {

    public static void main(String[] args) {
        Map<String, String> nameAndSurnameMap = new HashMap<>();
        nameAndSurnameMap.put(" vasile", "alex");
        nameAndSurnameMap.put("stan", "horia");

        Map<String, Integer> nameAndAgeMap = new HashMap<>();
        nameAndAgeMap.put("ana", 20);
        nameAndAgeMap.put("cristina", 25);

        Map<String, List<String>> nameAndFriendsMap = new HashMap<>();
        nameAndFriendsMap.put("cristi", Arrays.asList("robert, vali"));
        nameAndFriendsMap.put("diana", Arrays.asList("andreea, elena"));

        Map<String, Map<String, String>> nameAndDetailsMap = new HashMap<>();

        Map<String, String> mikeDetails = new HashMap<>();
        mikeDetails.put("id", "123");
        mikeDetails.put("birthPlace", "Bronx");

        Map<String, String> victoriaDetails = new HashMap<>();
        victoriaDetails.put("id", "345");
        victoriaDetails.put("birthPlace", "London");

        nameAndDetailsMap.put("mike", mikeDetails);
        nameAndDetailsMap.put("victoria", victoriaDetails);
    }
}
