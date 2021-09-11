package com.sda.advanced.chat;

import java.io.IOException;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        int portNumber = 4444;
        Socket socket = null;
        try {
            socket = new Socket("localhost", portNumber);
        } catch (IOException e) {
            System.out.println("Fatal connection error!");
            e.printStackTrace();
        }
    }
}
