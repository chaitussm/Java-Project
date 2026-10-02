package com.advanced.multiThreading.concurrentPackage;

import java.util.concurrent.locks.ReentrantLock;

public class reentrantLockOne {

    public static void main(String[] args)
    {
        ReentrantLock I = new ReentrantLock();

        I.lock();
        I.lock();

        System.out.println(I.isLocked());
        System.out.println(I.isHeldByCurrentThread());
        System.out.println(I.getQueueLength());
        I.unlock();
        System.out.println(I.getHoldCount());
        System.out.println(I.isLocked());
        I.unlock();
        System.out.println(I.isLocked());
        System.out.println(I.isFair());
    }
    
}
