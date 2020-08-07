package com.bucur.patterns.structural.bridge;

import com.bucur.patterns.structural.bridge.devices.Device;
import com.bucur.patterns.structural.bridge.devices.Radio;
import com.bucur.patterns.structural.bridge.devices.Tv;
import com.bucur.patterns.structural.bridge.remotes.AdvancedRemote;
import com.bucur.patterns.structural.bridge.remotes.BasicRemote;

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
