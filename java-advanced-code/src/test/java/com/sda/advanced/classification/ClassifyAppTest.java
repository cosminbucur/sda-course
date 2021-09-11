package com.sda.advanced.classification;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ClassifyAppTest {

    @Test
    void acceptanceTest() {
        // create regions
        Region nwRegion = createNWRegion();
        Region cRegion = createCRegion();
        Region neRegion = createNERegion();

        // add regions to a collection
        List<Region> regions = Arrays.asList(nwRegion, cRegion, neRegion);

        // select max from first property
        Algorithm algorithm = new Algorithm();

        String property1 = "unemploymentRate";
        String property2 = "averageTotalIncome";

        // rank each property
        List<Region> regionsSortedByUnemploymentRate = algorithm.sortAscendingBy(property1, regions);
        Map<Region, Integer> rankedMapByUnemploymentRate = algorithm.convertListToRankMap(regionsSortedByUnemploymentRate);

        List<Region> regionsSortedByAverageTotalIncome = algorithm.sortDescendingBy(property2, regions);
        Map<Region, Integer> rankedMapByTotalIncome = algorithm.convertListToRankMap(regionsSortedByAverageTotalIncome);

        // sum ranks of all properties by region
        Map<Region, Integer> rankSumMap = algorithm.sumRankOfProperties(rankedMapByUnemploymentRate, rankedMapByTotalIncome);

        // sort ascending by rank sum
        Map<Region, Integer> sortedRankSumMap = algorithm.sortAscendingByRankSum(rankSumMap);

        Map<Region, Integer> expectedMap = new HashMap<>();
        expectedMap.put(neRegion, 0);
        expectedMap.put(cRegion, 1);
        expectedMap.put(neRegion, 2);

        assertThat(sortedRankSumMap).isEqualTo(expectedMap);
    }

    private Region createNWRegion() {
        Region region = new Region();
        region.setUnemploymentRate(4.4);   // percentage
        region.setAverageTotalIncome(1157.05);
//        region.setGDP(81669.4);
//        region.setAverageTotalExpense(1017.45);
//        region.setWorkingPopulation(1168);
//        region.setPovertyRate(17.1) // percentage
        return region;
    }

    private Region createCRegion() {
        Region region = new Region();
        region.setUnemploymentRate(3.2);   // percentage
        region.setAverageTotalIncome(1136.27);
//        region.setGDP(81669.4);
//        region.setAverageTotalExpense(1017.45);
//        region.setWorkingPopulation(1168);
//        region.setPovertyRate(17.1) // percentage
        return region;
    }

    private Region createNERegion() {
        Region region = new Region();
        region.setUnemploymentRate(6.5);   // percentage
        region.setAverageTotalIncome(891.82);
//        region.setGDP(81669.4);
//        region.setAverageTotalExpense(1017.45);
//        region.setWorkingPopulation(1168);
//        region.setPovertyRate(17.1) // percentage
        return region;
    }
}
