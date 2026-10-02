package com.advanced.multiThreading.deadLock;

public class deadlockOne extends Thread {

    threadOne t1 = new threadOne();
    threadTwo t2 = new threadTwo();

    public void m1()
    {
        this.start();
        t1.methodOne(t2);
    }
    public void run() {
        t2.methodTwo(t1);
    }

    public static void main(String[] args) {
        deadlockOne d1 = new deadlockOne();
        d1.m1();
    }
    
}
