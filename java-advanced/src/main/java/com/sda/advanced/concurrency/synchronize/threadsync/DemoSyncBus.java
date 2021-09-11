package com.sda.advanced.concurrency.synchronize.threadsync;

public class DemoSyncBus {

    public static void main(String[] args) {
        BusReservation br = new BusReservation();
        PassengerThread p1 = new PassengerThread(2, br, "Ana");
        PassengerThread p2 = new PassengerThread(2, br, "Alex");
        p1.start();
        p2.start();
    }

    /*
    sync issue:
    Welcome Alex! There are 2 available seats.
    Welcome Ana! There are 2 available seats.
     */
}
