package com.advanced.multiThreading;

public class SynchronizationDemo extends Thread {

    public synchronized void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Child Thread: " + i);
        }
    
    }
}
