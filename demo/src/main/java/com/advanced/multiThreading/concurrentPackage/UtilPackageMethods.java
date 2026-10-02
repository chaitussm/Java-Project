package com.advanced.multiThreading.concurrentPackage;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class utilPackageMethods {

    /*
     * ReentrantLock provides more control than synchronized.
     * tryLock() allows a thread to attempt locking without waiting.
     * If the lock is unavailable, the thread can continue with other work.
     */

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();

        Thread t1 = new Thread(() -> {
            if (lock.tryLock()) {
                try {
                    System.out.println("Thread 1 acquired the lock");
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("Thread 1 could not acquire the lock");
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                if (lock.tryLock(1, TimeUnit.SECONDS)) {
                    try {
                        System.out.println("Thread 2 acquired the lock");
                    } finally {
                        lock.unlock();
                    }
                } else {
                    System.out.println("Thread 2 could not acquire the lock");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
