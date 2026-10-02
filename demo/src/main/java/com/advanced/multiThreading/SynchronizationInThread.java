package com.advanced.multiThreading;

public class SynchronizationInThread extends Thread {

    /*In this also output order is not as expected*/

    static int i = 0;

    public synchronized void run() {
        for (int j = 0; j < 5; j++) {
            i++;
            System.out.println("Child Thread: " + i);
        }
    }

    public synchronized void run1() {
        for (int j = 2; j < 7; j++) {
            i++;
            System.out.println("Child Thread 1: " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizationInThread thread = new SynchronizationInThread();
        SynchronizationInThread thread1 = new SynchronizationInThread();
        thread.start();
        thread1.start();
        for (int j = 0; j < 5; j++) {
            i++;
            System.out.println("Main Thread: " + i);
        }
    }
    
}
