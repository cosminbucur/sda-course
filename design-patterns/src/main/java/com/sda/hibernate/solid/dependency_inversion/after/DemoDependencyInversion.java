package com.bucur.solid.dependency_inversion.after;

import com.bucur.solid.dependency_inversion.after.highlevel.ElectricPowerSwitch;
import com.bucur.solid.dependency_inversion.after.highlevel.Switch;
import com.bucur.solid.dependency_inversion.after.highlevel.Switchable;
import com.bucur.solid.dependency_inversion.after.lowlevel.Fan;
import com.bucur.solid.dependency_inversion.after.lowlevel.LightBulb;

/*
High level modules should not depend on low-level modules.
Both should depend on abstractions.
Abstractions should not depend on details.
Details should depend on abstractions.
 */
public class DemoDependencyInversion {

    public static void main(String[] args) {
        Switchable switchableBulb = new LightBulb();
        Switch bulbPowerSwitch = new ElectricPowerSwitch(switchableBulb);
        bulbPowerSwitch.press();
        bulbPowerSwitch.press();

        Switchable switchableFan = new Fan();
        Switch fanPowerSwitch = new ElectricPowerSwitch(switchableFan);
        fanPowerSwitch.press();
        fanPowerSwitch.press();
    }
}
