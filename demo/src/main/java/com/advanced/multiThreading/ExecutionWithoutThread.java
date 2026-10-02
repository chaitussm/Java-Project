package com.advanced.multiThreading;

public class ExecutionWithoutThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Child Thread: " + i);
        }
    }

    public static void main(String[] args) {
        ExecutionWithoutThread thread = new ExecutionWithoutThread();
        thread.run(); // Calling run() directly, not starting a new thread
        for(int i = 0; i < 5; i++) {
            System.out.println("Main Thread: " + i);
        }
    }
    
    /*Here output is same as expected because run() method is called directly, so it executes in the main thread */
    
}
