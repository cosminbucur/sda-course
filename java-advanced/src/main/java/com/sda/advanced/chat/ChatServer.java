package com.sda.advanced.chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChatServer {

    private static ServerSocket serverSocket = null;
    private static List<ClientThread> clients;
    private static int portNumber = 4444;

    public static void main(String[] args) {
        System.out.println("please input username");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        scanner.close();

        try {
            serverSocket = new ServerSocket(portNumber);
            acceptClients();
        } catch (IOException e) {
            System.out.println("could not listen to port: " + portNumber);
            System.exit(1);
        }
    }

    public static void acceptClients() {
        clients = new ArrayList<>();

        while (true) {
            try {
                Socket socket = serverSocket.accept();
                ClientThread client = new ClientThread(socket);
                Thread thread = new Thread(client);
                thread.start();
                clients.add(client);
            } catch (IOException e) {
                System.out.println("Accept failed on: " + portNumber);
            }
        }
    }
}
