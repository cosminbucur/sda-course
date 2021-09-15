package com.sda.patterns.solid.liskov.after;

import com.sda.patterns.solid.liskov.before.Engine;

// you should be able to replace an object with any of its derived classes
// your code should never have to check which sub-type it's dealing with
public class DemoLiskovSubstitution {

    public static void main(String[] args) {
        DeviceWithoutEngine bike = new Bicycle();
        bike.startMoving();

        // engine makes sense to be on the car
        Engine engine = new Engine();
        DeviceWithEngine car = new Car();
        car.setEngine(engine);
        car.startEngine();

    }
}
