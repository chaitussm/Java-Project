package com.advanced.multiThreading;

public class setAndGetPriorityInTheread implements Runnable {

    /*public final void getPriority() {
        return Thread.currentThread().getPriority();
    }
    public final void setPriority(int priority) {
        Thread.currentThread().setPriority(priority);
    }
    
    NOTE: Even after settting the pririty the output wont be as expected beacuse of the tyhrtead scheduler in the operating systems.
    the default priority of the Main thread is 5 
    the default priority for all remaining thread default priority will be inherited from the parent thread 
    If we provide value more than MAX_PRIORITY or less than MIN_PRIORITY, it will throw IllegalArgumentException*/

    @Override
    public void run() {
        System.out.println("Child Thread Priority: " + Thread.currentThread().getPriority());
        for (int i = 0; i < 5; i++) {
            System.out.println("Child Thread: " + i);
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new setAndGetPriorityInTheread());
        thread.setPriority(Thread.MAX_PRIORITY); // Setting the priority of the child thread
        thread.start();
        System.out.println("Main Thread Priority: " + Thread.currentThread().getPriority());
        for(int i = 0; i < 5; i++) {
            System.out.println("Main Thread: " + i);
        }
    }
    
}
