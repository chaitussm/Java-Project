package com.multiThreading;

public class interruptMethodInThread  {

   

    public static void main(String[] args) {
        myThreadInterrupt thread = new myThreadInterrupt();
        thread.start();
        thread.interrupt();
    }
    
}
