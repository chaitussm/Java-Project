package com.advanced.multiThreading.concurrentPackage.exampleOne;

public class reentrantLockThread {
    
    public static void main(String[] args)
    {
        display d = new display();
        myThread t1 = new myThread(d, "Dhoni");
        myThread t2 = new myThread(d, "Kohli");
        t1.start();
        t2.start();
    }
}
