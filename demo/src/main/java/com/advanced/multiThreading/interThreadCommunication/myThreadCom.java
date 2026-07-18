package com.advanced.multiThreading.interThreadCommunication;

public class myThreadCom {

    public static void main(String[] args) throws InterruptedException {
        myThread t1 = new myThread();
        t1.start();

        synchronized (t1) {
            System.out.println("Main thread trying to call wait() method");
            t1.wait();
            System.out.println("Main thread got notification call");
            System.out.println("Total is: " + t1.total);
        }
        
    }
    
}
