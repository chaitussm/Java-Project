package com.advanced.multiThreading.threadGroup;

public class threadgroup {

     public static void main(String[] args) {
        ThreadGroup group = new ThreadGroup("MyThreadGroup");
        Thread t1 = new Thread(group, () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread 1: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        
        System.out.print(Thread.currentThread().getThreadGroup().getName());
        System.out.println("Active threads in group: " + group.activeCount());
        System.out.println(Thread.currentThread().getThreadGroup().getParent().getName());
     }
}
