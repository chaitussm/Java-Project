package com.advanced.multiThreading.daemonThreads;

public class daemonThread {
    /*
     * Daemon threads are background threads that help the JVM perform
     * supporting tasks such as garbage collection.
     * Main objective of daemon therads is to provide support for non-daemon threads, such as main thread.
     * By default main thread is always non-daemon and for all the remaining threads daemon nature will be inherited from parent to child.
     * i.e if the parent threda is daemon then automatically child thread is also daemon.
     * If the parent thread is non-daemon then child thread will also be non-daemon.
     * 
     * Important behavior:
     * - A thread is non-daemon by default.
     * - Once set as a daemon thread, it runs in the background.
     * - If only daemon threads are left running, the JVM may stop them
     *   when the main program finishes.
     *
     * In this example, the two threads are marked as daemon threads,
     * so they may not complete their full loop before the program exits.
     */

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Thread 1: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Thread 2: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        
        System.out.println("Is thread 1 a daemon thread? " + t1.isDaemon()); // Check if thread 1 is a daemon thread
        t1.setDaemon(true); // Set thread 1 as a daemon thread
        t1.start();
        System.out.println("Is thread 2 a daemon thread? " + t2.isDaemon()); // Check if thread 2 is a daemon thread
        t2.setDaemon(true); // Set thread 2 as a daemon thread
        t2.start();
    }
    
}
