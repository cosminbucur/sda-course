package com.bucur.example2;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class GetHostInfo {
    public static void main(String[] args) throws UnknownHostException {
        if (args.length != 1) {
            System.err.println("The program must get exactly 1 argument: the host");
            return;
        }

        InetAddress address = InetAddress.getByName(args[0]);
        System.out.printf("Looking up %s -> %s/%s%n", args[0], address.getHostName(), address.getHostAddress());
    }
}
