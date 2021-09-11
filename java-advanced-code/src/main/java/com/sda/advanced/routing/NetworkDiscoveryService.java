package com.sda.advanced.routing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NetworkDiscoveryService {

    private Stream<String> networkNames;
    private List<Network> networks = new ArrayList<>();
    private Router router;

    public NetworkDiscoveryService(Router router, Stream<String> networks) {
        this.networkNames = networks;
        this.router = router;
    }

    public void run() {
        networks = networkNames
            .map(networkString -> new Network(networkString))
            .collect(Collectors.toList());

        networks.forEach(network -> {
            // connect to each network
            router.connect(network);
        });

        printAllConnectedNetworks(networks);
    }

    private void printAllConnectedNetworks(List<Network> networks) {
        networks.stream()
            .filter(network -> network.isConnected())
            .forEach(network -> System.out.println(network));
    }
}
