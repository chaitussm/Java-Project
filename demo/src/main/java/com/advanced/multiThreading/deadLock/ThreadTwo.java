package com.advanced.multiThreading.deadLock;

public class threadTwo {

    public synchronized void methodTwo(threadOne t1) {
        System.out.println("Thread Two: Holding lock 2...");
        try { Thread.sleep(1000); } 
        catch (InterruptedException e) {}
        System.out.println("Thread Two: Waiting for lock 1...");
        t1.last();
    }
    
    public synchronized void last() {
        System.out.println("Thread Two: Inside last() method");
    }
}
