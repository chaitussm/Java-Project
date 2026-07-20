package com.advanced.multiThreading.modelsAndOtherConcepts;

/** This class demonstrates the use of suspend() and resume() methods in Java threads. we wil get this 
 * exception java.lang.ThreadDeath if we use suspend() and resume() methods because these methods are 
 * deprecated in Java 1.2 and later versions.Exception in thread "main" java.lang.UnsupportedOperationException
 */

public class suspendAndresume extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        suspendAndresume t1 = new suspendAndresume();
        t1.start();
        Thread.sleep(3000); // Let the thread run for 3 seconds
        //t1.suspend(); // Suspend the thread
        System.out.println("Thread suspended");
        Thread.sleep(3000); // Wait for 3 seconds while the thread is suspended
        //t1.resume(); // Resume the thread
        System.out.println("Thread resumed");
    }
    
}
