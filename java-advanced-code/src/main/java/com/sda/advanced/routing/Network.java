package com.sda.advanced.routing;

import java.util.Random;

public class Network {

    private String name;
    private NetworkSignal signal;
    private boolean connected;

    public Network(String name) {
        this.name = name;
        this.signal = NetworkSignal.getSignalByRandomNumber(getRandomSignal());
        this.connected = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NetworkSignal getSignal() {
        return signal;
    }

    public void setSignal(NetworkSignal signal) {
        this.signal = signal;
    }

    public boolean isConnected() {
        return connected;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }

    private int getRandomSignal() {
        Random random = new Random();
        return random.nextInt(NetworkSignal.values().length);
    }

    @Override
    public String toString() {
        return "Network{" +
            "name='" + name + '\'' +
            ", signal=" + signal +
            '}';
    }

    public enum NetworkSignal {
        NO_CONNECTION,
        LOW,
        MEDIUM,
        HIGH;

        public static NetworkSignal getSignalByRandomNumber(int input) {
            switch (input) {
                case 0:
                    return NO_CONNECTION;
                case 1:
                    return LOW;
                case 2:
                    return MEDIUM;
                case 3:
                    return HIGH;
                default:
                    System.out.println("unknown signal option");
            }
            return null;
        }
    }
}
