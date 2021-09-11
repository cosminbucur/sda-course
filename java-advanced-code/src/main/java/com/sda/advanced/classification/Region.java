package com.sda.advanced.classification;

import java.util.Objects;

public class Region {

    public double unemploymentRate;
    public double averageTotalIncome;

    public double getUnemploymentRate() {
        return unemploymentRate;
    }

    public void setUnemploymentRate(double unemploymentRate) {
        this.unemploymentRate = unemploymentRate;
    }

    public double getAverageTotalIncome() {
        return averageTotalIncome;
    }

    public void setAverageTotalIncome(double averageTotalIncome) {
        this.averageTotalIncome = averageTotalIncome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Region region = (Region) o;
        return Double.compare(region.unemploymentRate, unemploymentRate) == 0 &&
            Double.compare(region.averageTotalIncome, averageTotalIncome) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(unemploymentRate, averageTotalIncome);
    }

    @Override
    public String toString() {
        return "Region{" +
            "unemploymentRate=" + unemploymentRate +
            ", averageTotalIncome=" + averageTotalIncome +
            '}';
    }
}
