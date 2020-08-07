package com.bucur.routing;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class RoutingApp {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("C:\\dev\\sda\\sda\\java-advanced-code\\src\\main\\resources\\networks.txt");
        Stream<String> networkNames = Files.lines(path);

        Router router = new Router();
        NetworkDiscoveryService service = new NetworkDiscoveryService(router, networkNames);
        service.run();
    }

}
