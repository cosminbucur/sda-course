package com.bucur.example1;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class LocalHost {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getLocalHost();
        System.out.printf("%s/%s%n", address.getHostName(), address.getHostAddress());
    }
}
