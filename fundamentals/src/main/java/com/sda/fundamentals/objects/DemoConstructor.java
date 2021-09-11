package com.sda.fundamentals.objects;

public class DemoConstructor {

    public static void main(String[] args) {
        Boat boat1 = new Boat();
        // set state after construction
        boat1.setColor("blue");
        boat1.setMaxSpeed(100);

        // set state during construction
        Boat boat2 = new Boat("red", 200);
    }
}

class Boat {

    private String color;
    private int maxSpeed;

    // TIP: created by the compiler by default
    // constructor no param
    Boat() {
        System.out.println("empty constructor");
    }

    // TIP: if another constructor, empty constructor not available
    // constructor multiple params (overloading)
    public Boat(String color, int maxSpeed) {
        this.color = color;
        this.maxSpeed = maxSpeed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
