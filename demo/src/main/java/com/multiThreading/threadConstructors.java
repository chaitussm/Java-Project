package com.multiThreading;

public class threadConstructors implements Runnable {

    /*This conde contains all the available thread constructors */

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Child Thread: " + i);
            }           
        }
     
    public static void main(String[] args) {

        System.out.println("Main Thread: " + Thread.currentThread().getName());
        Thread thread1 = new Thread();
        thread1.setName("Thread Alpha");
        Thread thread2 = new Thread(new threadConstructors());
        Thread thread3 = new Thread(new threadConstructors(), "Thread 3");
        Thread thread4 = new Thread(thread2);
        Thread thread5 = new Thread(thread2, "Thread 5");
        // Use the (ThreadGroup, Runnable, String, long) constructor to supply a stack-size
        long stackSize = Long.MAX_VALUE;
        Thread thread6 = new Thread(Thread.currentThread().getThreadGroup(), thread2, "Thread 6", stackSize);
        System.out.println("Thread 1: " + thread1.getName());
        System.out.println("Thread 1 priority is : " + thread1.getPriority());
        System.out.println("Thread 2: " + thread2.getName());
        System.out.println("Thread 2 priority is : " + thread2.getPriority());
        System.out.println("Thread 3: " + thread3.getName());
        System.out.println("Thread 3 priority is : " + thread3.getPriority());
        System.out.println("Thread 4: " + thread4.getName());
        System.out.println("Thread 4 priority is : " + thread4.getPriority());
        System.out.println("Thread 5: " + thread5.getName());
        System.out.println("Thread 5 priority is : " + thread5.getPriority());
        System.out.println("Thread 6: " + thread6.getName());
        System.out.println("Thread 6 priority is : " + thread6.getPriority());
        System.out.println("Thread 6 requested stack size: " + stackSize);
    }
    
}
