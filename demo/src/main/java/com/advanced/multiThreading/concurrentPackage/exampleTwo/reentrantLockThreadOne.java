package com.advanced.multiThreading.concurrentPackage.exampleTwo;

public class reentrantLockThreadOne {

    public static void main(String[] args)
    {
        myThreadOne t1 = new myThreadOne("First Thread");
        myThreadOne t2 = new myThreadOne("Second Thread");
        t1.start();
        t2.start();
    }
    
}
