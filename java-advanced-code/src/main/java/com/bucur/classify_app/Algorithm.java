package com.bucur.classify_app;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

public class Algorithm {

    // use map of double - int

    public Field[] getFieldsFromRegion() {
        Class regionClass = Region.class;
        return regionClass.getFields();
    }

    public List<Region> sortAscendingBy(String property1, List<Region> regions) {
        Comparator<Region> compareByUnemploymentRate = (Region r1, Region r2) -> (int) (r1.getUnemploymentRate() - r2.getUnemploymentRate());
        regions.sort(compareByUnemploymentRate);
        return regions;
    }

    public List<Region> sortDescendingBy(String property, List<Region> regions) {
        Comparator<Region> compareByAverageTotalIncome = (Region r1, Region r2) -> (int) (r2.getAverageTotalIncome() - r1
            .getAverageTotalIncome());
        regions.sort(compareByAverageTotalIncome);
        return regions;
    }

    public Map<Region, Integer> convertListToRankMap(List<Region> regions) {
        // get index of each region
        Map<Region, Integer> result = new HashMap<>();
        for (int i = 1; i <= regions.size(); i++) {
            // add to map (region, index)
            result.put(regions.get(i - 1), i);
        }

        return result;
    }

    public Map<Region, Integer> sumRankOfProperties(Map<Region, Integer>... maps) {
        // iterate maps
        Map<Region, Integer> result = new HashMap<>();

        for (Map<Region, Integer> map : maps) {
            for (Region region : map.keySet()) {

                // get rank by region from each map and sum
                if (result.containsKey(region)) {
                    // update existing entry
                    int previousSum = result.get(region);

                    result.replace(region, previousSum + map.get(region));
                } else {
                    // add new entry
                    result.put(region, map.get(region));
                }
            }
        }
        return result;
    }

    public Map<Region, Integer> sortAscendingByRankSum(Map<Region, Integer> rankSumMap) {
        return rankSumMap.entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue())
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }

    public Map<Region, Integer> getResult(Map<Region, Integer> initialRankSumMap, Map<Region, Integer> sortedRankSumMap) {
        Map<Region, Integer> result = new LinkedHashMap<>();

//
//        Object[] sortedArrayOfEntries = sortedRankSumMap.entrySet().iterator();
//
//        for (int i = 0; i < sortedArrayOfEntries.length; i++) {
//            sortedArrayOfEntries[i]
//        }
//
//        for (Map.Entry<Region, Integer> entry : initialRankSumMap.entrySet()) {
//            sortedEntrySet
//        }

        return null;
    }

}
