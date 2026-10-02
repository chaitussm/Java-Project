package com.advanced.multiThreading.concurrentPackage.exampleOne;

import java.util.concurrent.locks.ReentrantLock;

public class display {

    ReentrantLock I = new ReentrantLock();

    public void wish(String name)
    {
        I.lock();

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

        I.unlock();
    }
    
}
