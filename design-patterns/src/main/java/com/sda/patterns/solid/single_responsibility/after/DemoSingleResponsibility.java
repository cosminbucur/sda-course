package com.sda.patterns.solid.single_responsibility.after;

// each class has a single purpose and all it's methods should relate to function
public class DemoSingleResponsibility {

    public static void main(String[] args) {
        HRPromotions hrPromotions = new HRPromotions();
        TaxCalculations taxCalculations = new TaxCalculations();

        Employee employee = new Employee();
        hrPromotions.isPromotionDueThisYear(employee);
        taxCalculations.calculateTaxForCurrentYear(employee);
    }
}
