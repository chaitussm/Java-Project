package com.advanced.multiThreading.threadpools.threadpoolWithRunnable;

public class printJob implements Runnable{

    /*Creating a new thread will create performance and memory problem to overcome this we should go for thread pool
    Thread pool isa pool of already created threads ready to do our job
    java 1.5 introduced the thread pool framework also lnown as executor framework */
    
    String name;

    printJob(String name)
    {
        this.name = name;
    }

    public void run()
    {
        System.out.println(name + "...Job Started by Thread :" + Thread.currentThread().getName());

        try{

            Thread.sleep(5000);
        }
        catch(InterruptedException e )
        {

        }

        System.out.println(name + "...Job completed by Thread : " + Thread.currentThread().getName());
    }

    
}
