package com.advanced.multiThreading.starvation;

public class starvation {

    /*long waiting of a thread wheer waiting never ends is called deadlock
    whereas long waiting of a thread where waiting eventually ends is called starvation
    example for starvation is in the below */

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("Thread 1: " + i);
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("Thread 2: " + i);
                }
            }
        });

        t1.setPriority(Thread.MIN_PRIORITY); // Set low priority for thread 1
        t2.setPriority(Thread.MAX_PRIORITY); // Set high priority for thread 2

        t1.start();
        t2.start();
    }
    
}
