package com.multiThreading;

/*If a thread waits until the other thread execution is completed then we can go for join() method 
 Every join() throws InterruptedException */

public class joinMethodInThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Child Thread: " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new joinMethodInThread());
        thread.start();
        thread.join(); // Main thread will wait for this thread to finish
        thread.join(1000); // This will wait for 1000 milliseconds
        thread.join(1000,2000); // This will wait for 1000 milliseconds with a timeout of 2000 milliseconds
        for(int i = 0; i < 5; i++) {
            System.out.println("Main Thread: " + i);
        }
    }
    
}
