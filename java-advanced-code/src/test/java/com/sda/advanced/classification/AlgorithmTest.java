package com.sda.advanced.classification;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class AlgorithmTest {

    // membru = proprietate = field = instance variable
    @Test
    public void givenARegionClass_getFieldsFromRegion_thenReturnArrayOfFields() {
        Algorithm algorithm = new Algorithm();

        Field[] actualFields = algorithm.getFieldsFromRegion();
        assertThat(actualFields.length).isEqualTo(2);
    }

    @Test
    public void givenTwoRegions_whenSortAscendingByUnemploymentRate_thenReturnSortedList() {
        Region region1 = new Region();
        region1.setUnemploymentRate(20);

        Region region2 = new Region();
        region2.setUnemploymentRate(10);
        List<Region> unsortedList = Arrays.asList(region1, region2);

        List<Region> expectedList = Arrays.asList(region2, region1);

        String property = "unemploymentRate";
        Algorithm algorithm = new Algorithm();

        List<Region> actualList = algorithm.sortAscendingBy(property, unsortedList);

        assertThat(actualList).isEqualTo(expectedList);
    }

    @Test
    public void givenTwoRegions_whenSortDescendingByAverageTotalIncome_thenReturnSortedList() {
        Region region1 = new Region();
        region1.setAverageTotalIncome(30);

        Region region2 = new Region();
        region2.setAverageTotalIncome(40);
        List<Region> unsortedList = Arrays.asList(region1, region2);

        List<Region> expectedList = Arrays.asList(region2, region1);

        String property = "averageTotalIncome";
        Algorithm algorithm = new Algorithm();

        List<Region> actualList = algorithm.sortDescendingBy(property, unsortedList);

        assertThat(actualList).isEqualTo(expectedList);
    }

    @Test
    public void givenTwoRegions_whenConvertListToRankMap_thenReturnRankedMap() {
        Region region1 = new Region();
        region1.setUnemploymentRate(10);

        Region region2 = new Region();
        region2.setUnemploymentRate(20);
        List<Region> regions = Arrays.asList(region1, region2);

        Map<Region, Integer> expectedMap = new HashMap<>();
        expectedMap.put(region1, 1);
        expectedMap.put(region2, 2);

        Algorithm algorithm = new Algorithm();

        Map<Region, Integer> actualMap = algorithm.convertListToRankMap(regions);

        assertThat(actualMap).isEqualTo(expectedMap);
    }

    @Test
    public void givenTwoMaps_whenSumRankOfProperties_thenReturnRankedSumMap() {
        Region region1 = new Region();
        region1.setUnemploymentRate(10);
        region1.setAverageTotalIncome(30);

        Region region2 = new Region();
        region2.setUnemploymentRate(20);
        region2.setAverageTotalIncome(40);

        Map<Region, Integer> rankedMapByUnemploymentRate = new HashMap<>();
        rankedMapByUnemploymentRate.put(region1, 1);
        rankedMapByUnemploymentRate.put(region2, 2);

        Map<Region, Integer> rankedMapByTotalIncome = new HashMap<>();
        rankedMapByTotalIncome.put(region1, 2);
        rankedMapByTotalIncome.put(region2, 1);

        Map<Region, Integer> expectedMap = new HashMap<>();
        expectedMap.put(region1, 3);
        expectedMap.put(region2, 3);

        Algorithm algorithm = new Algorithm();

        Map<Region, Integer> actualMap = algorithm.sumRankOfProperties(rankedMapByUnemploymentRate, rankedMapByTotalIncome);

        assertThat(actualMap).isEqualTo(expectedMap);
    }

    @Test
    public void givenMapWithTwoRegions_whenSortAscendingByRankSum_thenReturnSortedMap() {
        Region region1 = new Region();
        region1.setUnemploymentRate(10);
        Region region2 = new Region();
        region2.setUnemploymentRate(20);

        Map<Region, Integer> rankSumMap = new LinkedHashMap<>();
        rankSumMap.put(region1, 3);
        rankSumMap.put(region2, 2);

        Map<Region, Integer> expectedMap = new LinkedHashMap<>();
        expectedMap.put(region2, 2);
        expectedMap.put(region1, 3);

        Algorithm algorithm = new Algorithm();

        Map<Region, Integer> actualMap = algorithm.sortAscendingByRankSum(rankSumMap);

        assertThat(actualMap).isEqualTo(expectedMap);
    }

    @Test
    public void givenMapWithTwoRegions1_whenSortAscendingByRankSum_thenReturnSortedMap() {
        Region region1 = new Region();
        Region region2 = new Region();

        Map<Region, Integer> rankSumMap = new HashMap<>();
        rankSumMap.put(region1, 3);
        rankSumMap.put(region2, 2);

        Map<Region, Integer> expectedMap = new HashMap<>();
        expectedMap.put(region1, 2);
        expectedMap.put(region2, 1);

        Algorithm algorithm = new Algorithm();

        Map<Region, Integer> actualMap = algorithm.sortAscendingByRankSum(rankSumMap);

        assertThat(actualMap).isEqualTo(expectedMap);
    }
}
