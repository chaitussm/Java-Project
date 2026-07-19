package com.advanced.multiThreading.daemonThreads;

public class daeomonThreadexample {

    public static void main(String[] args) {
        daemonMyThread t1 = new daemonMyThread();
        t1.setDaemon(true);
        t1.start();
        System.out.println("End of main thread");
        
    }
    
}
