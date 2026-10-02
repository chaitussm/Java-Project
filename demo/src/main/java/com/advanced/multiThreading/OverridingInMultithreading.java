package com.advanced.multiThreading;

public class overridingInMultithreading extends Thread {

    /*@Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Child Thread: " + i);
        }
    }
    In this scenario if we dont override the run() method 
    default run() inside the thread class will be called but it is empty so no output*/

    public static void main(String[] args) {
        overridingInMultithreading thread = new overridingInMultithreading();
        thread.start();
    }
    
}
