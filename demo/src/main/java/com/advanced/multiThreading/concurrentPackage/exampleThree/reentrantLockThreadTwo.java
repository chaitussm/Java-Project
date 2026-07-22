package com.advanced.multiThreading.concurrentPackage.exampleThree;

public class reentrantLockThreadTwo {

    public static void main(String[] args)
    {
        myThreadTwo t1 = new myThreadTwo("First Thread");
        myThreadTwo t2 = new myThreadTwo("Second Thread");
        t1.start();
        t2.start();
    }
    
}
