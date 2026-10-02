package com.advanced.multiThreading.concurrentPackage;

import java.util.concurrent.locks.ReentrantLock;

public class reentrantLock {

    /*
     * ReentrantLock allows a thread to acquire the same lock multiple times.
     * RenetrantLock means a thread can acquire same lock without any issue 
     * Internally rentrant lock increments threads personal count whenever we call lock method and decrements count value 
     * whenever thread calls unlcok method and lock will be released whenever count reaches zero
     */

    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("Thread 1 acquired the lock");
                performTask();
            } finally {
                lock.unlock();
            }
        });

        Thread t2 = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("Thread 2 acquired the lock");
            } finally {
                lock.unlock();
            }
        });

        t1.start();
        t2.start();
    }

    private static void performTask() {
        lock.lock();
        try {
            System.out.println("Nested lock acquired by the same thread");
        } finally {
            lock.unlock();
        }
    }
}
