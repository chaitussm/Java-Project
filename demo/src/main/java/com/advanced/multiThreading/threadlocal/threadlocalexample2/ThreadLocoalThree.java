package com.advanced.multiThreading.threadlocal.threadlocalexample2;

public class threadLocoalThree {

    public static void main(String[] args)
    {
        customerThread t1 = new customerThread("Customer Thread-1");
        customerThread t2 = new customerThread("Customer Thread-2");
        customerThread t3 = new customerThread("Customer Thread-3");
        customerThread t4 = new customerThread("Customer Thread-4");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    
    }
    
}
