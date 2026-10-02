package com.advanced.multiThreading.threadlocal.threadlocalexample1;

public class threadlocalDemo {

    public static void main(String[] args)
    {
        parentThread p = new parentThread();
        p.start();
    }
    
}
