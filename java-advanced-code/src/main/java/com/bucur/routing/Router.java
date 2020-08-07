package com.bucur.routing;

public class Router implements Connectable {

    @Override
    public boolean connect(Network network) {
        // if is not already connected and if signal low, med, or high

        if (!network.isConnected() &&
            !network.getSignal().equals(Network.NetworkSignal.NO_CONNECTION)) {
            System.out.println("connected to network: " + network.getName() + " with signal " + network.getSignal());
            return true;
        } else {
            throw new NetworkUnavailableException(
                "can not connect to the network :" + network.getName() +
                    " because the network signal is: " + network.getSignal().name());
        }
    }
}
