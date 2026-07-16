package com.multiThreading;

public class sleepMethodInThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Seetha Thread: " + i);
            try {
                Thread.sleep(1000); // Sleep for 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new sleepMethodInThread());
        thread.start();
        thread.join(); // Main thread will wait for this thread to finish
        for(int i = 0; i < 5; i++) {
            System.out.println("Rama Thread: " + i);
            try {
                Thread.sleep(5); // Sleep for 0.5 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
}
