package com.multiThreading;

public class myThread extends Thread {

    @Override
    public void run() {
        super.start();
        for (int i = 0; i < 5; i++) {
            System.out.println("Child Thread: " + i);
        }
    }


    
}
