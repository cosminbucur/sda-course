package com.sda.patterns.solid.dependency_inversion.after.lowlevel;

import com.sda.patterns.solid.dependency_inversion.after.highlevel.Switchable;

public class Fan implements Switchable {

    @Override
    public void turnOn() {
        System.out.println("Fan: Fan turned on...");
    }

    @Override
    public void turnOff() {
        System.out.println("Fan: Fan turned off...");
    }
}
