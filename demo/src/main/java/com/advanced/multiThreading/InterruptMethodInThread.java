package com.advanced.multiThreading;

public class InterruptMethodInThread  {

   

    public static void main(String[] args) {
        MyThreadInterrupt thread = new MyThreadInterrupt();
        thread.start();
        thread.interrupt();
    }
    
}
