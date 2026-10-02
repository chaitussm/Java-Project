package com.advanced.multiThreading;

public class executionWithoutThreadCreation extends Thread {

    @Override
    public void start() {
        System.out.println("Child Thread: " + Thread.currentThread().getName());
        
    }

    public static void main(String[] args) {
        executionWithoutThreadCreation thread = new executionWithoutThreadCreation();
        thread.start(); // Calling start() method, which creates a new thread
        //but here start method inside the class gets priority retaher the method inside the thread class
        System.out.println("Main Thread: " + Thread.currentThread().getName());

    }
    
    /*Here output is same as expected because run() method is called directly, so it executes in the main thread */
    
}
