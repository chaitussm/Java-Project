package com.multiThreading;

public class threadPriority implements Runnable {

    /*Thread class is having 1 to 10 priority levels where 1 stands for minimum priority and 10 stands for maximum priority */
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new threadPriority());
        Thread thread2 = new Thread(new threadPriority());
        Thread thread3 = new Thread(new threadPriority());

        thread1.setPriority(Thread.MIN_PRIORITY); // Setting minimum priority
        thread2.setPriority(Thread.NORM_PRIORITY); // Setting normal priority
        thread3.setPriority(Thread.MAX_PRIORITY); // Setting maximum priority

        thread1.start();
        thread2.start();
        thread3.start();
    }
    
}
