package com.sda.advanced.concurrency.synchronize.threadsync;

public class BusReservation implements Runnable {

    private int availableSeats = 2;

    @Override
    public void run() {
        PassengerThread pt = (PassengerThread) Thread.currentThread();

        boolean ticketsBooked = this.bookTickets(pt.getSeatsNeeded());

        if (ticketsBooked) {
            System.out.println("Ok, " + Thread.currentThread().getName() + ", you have booked " + pt.getSeatsNeeded() + " seats.");
        } else {
            System.out.println("Sorry " + Thread.currentThread().getName() + ", " + pt.getSeatsNeeded() + " seats are not available.");
        }
    }

    public synchronized boolean bookTickets(int seats) {
//    public boolean bookTickets(int seats) {
        System.out.println("Welcome " + Thread.currentThread().getName() + "! There are " + this.getAvailableSeats() + " available seats.");

        if (seats > this.getAvailableSeats()) {
            return false;
        } else {
            availableSeats = availableSeats - seats;
            return true;
        }
    }

    public int getAvailableSeats() {
        return availableSeats;
    }
}
