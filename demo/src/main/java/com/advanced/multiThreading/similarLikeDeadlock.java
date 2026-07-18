package com.advanced.multiThreading;

public class similarLikeDeadlock extends Thread {

    /*This code wont be executed because main is the entry point */

    public static void main(String[] args) throws InterruptedException {
      
        Thread.currentThread().join();
    }
}
