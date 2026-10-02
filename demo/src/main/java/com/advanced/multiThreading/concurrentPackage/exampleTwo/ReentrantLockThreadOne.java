package com.advanced.multiThreading.concurrentPackage.exampleTwo;

public class ReentrantLockThreadOne {

    public static void main(String[] args)
    {
        MyThreadOne t1 = new MyThreadOne("First Thread");
        MyThreadOne t2 = new MyThreadOne("Second Thread");
        t1.start();
        t2.start();
    }
    
}
