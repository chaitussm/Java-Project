package com.advanced.multiThreading.concurrentPackage.exampleThree;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class myThreadTwo extends Thread{

    static ReentrantLock I = new ReentrantLock();

    myThreadTwo(String name)
    {
        super(name);
    }

    public void run()
    {
        do{
             try{
                if( I.tryLock(5000, TimeUnit.MILLISECONDS))
                {
                    System.out.println(Thread.currentThread().getName() + "...got lock");
                    Thread.sleep(30000);
                    I.unlock();
                    System.out.println(Thread.currentThread().getName() + "..got unlocked");
                    break;
                }

                else
                {
                    System.out.println(Thread.currentThread().getName() + "...unable to get the lock and will try again");
                }
             }

             catch(Exception e)
             {

             }
        }

        while(true);
    }
    
}
