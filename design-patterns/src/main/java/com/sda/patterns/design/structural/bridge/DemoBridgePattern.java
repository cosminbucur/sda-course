package com.sda.patterns.design.structural.bridge;

import com.sda.patterns.design.structural.bridge.devices.Device;
import com.sda.patterns.design.structural.bridge.devices.Radio;
import com.sda.patterns.design.structural.bridge.devices.Tv;
import com.sda.patterns.design.structural.bridge.remotes.AdvancedRemote;
import com.sda.patterns.design.structural.bridge.remotes.BasicRemote;

public class DemoBridgePattern {

    public static void main(String[] args) {
        testDevice(new Tv());
        testDevice(new Radio());
    }

    public static void testDevice(Device device) {
        System.out.println("Tests with basic remote.");
        BasicRemote basicRemote = new BasicRemote(device);
        basicRemote.power();
        device.printStatus();

        System.out.println("Tests with advanced remote.");
        AdvancedRemote advancedRemote = new AdvancedRemote(device);
        advancedRemote.power();
        advancedRemote.mute();
        device.printStatus();
    }
}
