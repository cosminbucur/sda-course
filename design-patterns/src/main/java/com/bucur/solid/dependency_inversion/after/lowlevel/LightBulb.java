package com.bucur.solid.dependency_inversion.after.lowlevel;

import com.bucur.solid.dependency_inversion.after.highlevel.Switchable;

public class LightBulb implements Switchable {

    @Override
    public void turnOn() {
        System.out.println("LightBulb: Bulb turned on...");
    }

    @Override
    public void turnOff() {
        System.out.println("LightBulb: Bulb turned off...");
    }
}
