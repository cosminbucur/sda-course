package com.sda.advanced.concurrency.synchronize.join;

public class DemoJoin {

    public static Thread t1;
    public static Thread t2;

    public static void main(String[] args) {
        JoinThreads joinThreads = new JoinThreads();
        t1 = new Thread(joinThreads, "T1");
        t2 = new Thread(joinThreads, "T2");
        t1.start();

        while (true) {
            Thread.State t1State = t1.getState();
            Thread.State t2State = t2.getState();

            System.out.println(System.nanoTime() + " T1: " + t1State);
            System.out.println(System.nanoTime() + " T2: " + t2State);

            if (t1State.equals(Thread.State.TERMINATED) && t2.getState().equals(Thread.State.TERMINATED)) {
                break;
            }
        }
//        t2.start();
    }
}
