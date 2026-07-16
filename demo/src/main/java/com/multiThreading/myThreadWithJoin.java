package com.multiThreading;

public class myThreadWithJoin extends Thread{

    static Thread t1;

    public void run() {
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 5; i++) {
            System.out.println("Child Thread: " + i);
        }
    }
    
}
