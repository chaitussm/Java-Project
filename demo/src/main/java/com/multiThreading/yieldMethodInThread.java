package com.multiThreading;

public class yieldMethodInThread implements Runnable {

    /*output is not guaranteed to be in a specific order */
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Child Thread: " + i);
            Thread.yield(); // Suggests that the current thread is willing to yield its current use of a processor
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new yieldMethodInThread());
        thread.start();
        for(int i = 0; i < 5; i++) {
            System.out.println("Main Thread: " + i);
        }
    }
    
}
