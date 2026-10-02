package com.advanced.multiThreading.concurrentPackage.exampleOne;

import java.util.concurrent.locks.ReentrantLock;

public class Display {

    ReentrantLock i = new ReentrantLock();

    public void wish(String name)
    {
        i.lock();

        for(int i = 0; i<10;i++)
        {
            System.out.print("Good morning:");
            try{

                Thread.sleep(1000);
            }
            catch(InterruptedException e)
            {

            }
            System.out.println(name);
        }

        i.unlock();
    }
    
}
