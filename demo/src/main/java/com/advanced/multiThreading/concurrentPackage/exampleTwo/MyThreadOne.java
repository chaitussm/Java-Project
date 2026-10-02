package com.advanced.multiThreading.concurrentPackage.exampleTwo;

import java.util.concurrent.locks.ReentrantLock;

public class MyThreadOne extends Thread{

    static ReentrantLock I = new ReentrantLock();

    MyThreadOne(String name)
    {
       super(name);
    }
    
    public void run()
    {
       if(I.tryLock())
       {
         System.out.println(Thread.currentThread().getName() + "===== got lock and performing safe operations");
             try{
              Thread.sleep(1000);
             }
             catch(InterruptedException e)
             {
             I.unlock();
             }
       }  

       else{

        System.out.println(Thread.currentThread().getName() + "--- unable to get lock and hence performing alternating operations");
       }


    }
}
