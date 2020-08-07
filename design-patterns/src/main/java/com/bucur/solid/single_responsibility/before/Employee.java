package com.bucur.solid.single_responsibility.before;

import java.time.LocalDate;

public class Employee {

    private String id;
    private String name;
    private String address;
    private LocalDate joinDate;

    public boolean isPromotionDueThisYear() {
        // promotion logic
        return true;
    }

    public Double calculateTaxForCurrentYear() {
        // income tax logic
        return 0.0;
    }
}
