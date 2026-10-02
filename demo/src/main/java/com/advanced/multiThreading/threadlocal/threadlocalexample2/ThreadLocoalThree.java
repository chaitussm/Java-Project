package com.advanced.multiThreading.threadlocal.threadlocalexample2;

public class ThreadLocoalThree {

    public static void main(String[] args)
    {
        CustomerThread t1 = new CustomerThread("Customer Thread-1");
        CustomerThread t2 = new CustomerThread("Customer Thread-2");
        CustomerThread t3 = new CustomerThread("Customer Thread-3");
        CustomerThread t4 = new CustomerThread("Customer Thread-4");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    
    }
    
}
