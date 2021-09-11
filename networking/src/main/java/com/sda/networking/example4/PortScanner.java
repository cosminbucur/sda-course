package com.sda.networking.example4;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class PortScanner {

    public static void main(String[] args) {
        if (args.length != 3) {
            System.err.println("The program must get exactly 3 arguments: the server, the start port and the end port");
            return;
        }

        String host = args[0];
        int startPort = Integer.valueOf(args[1]);
        int endPort = Integer.valueOf(args[2]);

        for (int port = startPort; port <= endPort; port++) {
            try {
                Socket socket = new Socket();
                socket.connect(new InetSocketAddress(host, port), 1000);
                socket.close();
                System.out.println("Port " + port + " is open");
            } catch (IOException e) {

            }
        }
    }

}
