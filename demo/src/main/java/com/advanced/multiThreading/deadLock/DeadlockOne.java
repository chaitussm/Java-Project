package com.advanced.multiThreading.deadLock;

public class DeadlockOne extends Thread {

    ThreadOne t1 = new ThreadOne();
    ThreadTwo t2 = new ThreadTwo();

    public void m1()
    {
        this.start();
        t1.methodOne(t2);
    }
    public void run() {
        t2.methodTwo(t1);
    }

    public static void main(String[] args) {
        DeadlockOne d1 = new DeadlockOne();
        d1.m1();
    }
    
}
