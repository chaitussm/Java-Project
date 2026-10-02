package com.advanced.multiThreading.threadGroup;

public class myThread extends Thread{

     myThread(ThreadGroup g, String name)
     {
        super(g, name);
     }

     public void run()
     {
        System.out.println("Child Thread");
        try{
            Thread.sleep(5000);
        }
        catch(InterruptedException e)
        {

        }
     }

    
}
