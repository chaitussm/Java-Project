package com.advanced.multiThreading.concurrentPackage.exampleThree;

public class ReentrantLockThreadTwo {

    public static void main(String[] args)
    {
        MyThreadTwo t1 = new MyThreadTwo("First Thread");
        MyThreadTwo t2 = new MyThreadTwo("Second Thread");
        t1.start();
        t2.start();
    }
    
}
