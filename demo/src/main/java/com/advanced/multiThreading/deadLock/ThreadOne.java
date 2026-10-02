package com.advanced.multiThreading.deadLock;

public class ThreadOne {

    public synchronized void methodOne(ThreadTwo t2) {
        System.out.println("Thread One: Holding lock 1...");
        try { Thread.sleep(100); } catch (InterruptedException e) {}
        System.out.println("Thread One: Waiting for lock 2...");
        t2.last();
    }
    
    public synchronized void last() {
        System.out.println("Thread One: Inside last() method");
    }

    
}
