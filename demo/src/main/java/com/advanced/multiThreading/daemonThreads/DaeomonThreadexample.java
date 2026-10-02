package com.advanced.multiThreading.daemonThreads;

public class DaeomonThreadexample {

    public static void main(String[] args) {
        DaemonMyThread t1 = new DaemonMyThread();
        t1.setDaemon(true);
        t1.start();
        System.out.println("End of main thread");
        
    }
    
}
