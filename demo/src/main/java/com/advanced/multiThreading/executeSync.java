package com.advanced.multiThreading;

public class executeSync extends Thread {
    
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Child Thread: " + i);
        }
    
    }

    public static void main(String[] args) {
        executeSync thread = new executeSync();
        SynchronizationDemo demo = new SynchronizationDemo();
        demo.start();
        thread.start();
        for(int i = 0; i < 5; i++) {
            System.out.println("Main Thread: " + i);
        }
    }
}