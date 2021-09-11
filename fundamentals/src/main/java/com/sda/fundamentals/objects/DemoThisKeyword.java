package com.sda.fundamentals.objects;

public class DemoThisKeyword {

    public static void main(String[] args) {
        Bike blueBike = new Bike("blue");
        System.out.println(blueBike + " has color " + blueBike.getColor());
        Bike redBike = new Bike("red");
        System.out.println(redBike + " has color " + redBike.getColor());
    }
}

class Bike {

    private String color;

    public Bike(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
