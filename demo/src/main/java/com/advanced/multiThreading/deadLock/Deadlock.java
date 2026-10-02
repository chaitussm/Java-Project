package com.advanced.multiThreading.deadLock;

/*Two threads are waiting for each other forever
There is no resolution for the Deadlock we can only prevent it */

public class Deadlock extends Thread {

    static String resource1 = "resource1";
    static String resource2 = "resource2";

    // t1 tries to lock resource1 then resource2
    public void run() {
        synchronized (resource1) {
            System.out.println(Thread.currentThread().getName() + " locked " + resource1);

            try { Thread.sleep(100);} catch (Exception e) {}

            synchronized (resource2) {
                System.out.println(Thread.currentThread().getName() + " locked " + resource2);
            }
        }
    }

    public static void main(String[] args) {
        Deadlock t1 = new Deadlock();
        Deadlock t2 = new Deadlock();

        t1.start();
        t2.start();
    }
    
}
