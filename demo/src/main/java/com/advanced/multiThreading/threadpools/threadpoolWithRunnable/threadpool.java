package com.advanced.multiThreading.threadpools.threadpoolWithRunnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class threadpool {

    public static void main(String[] args)
    {
        printJob[] jobs = {
            new printJob("durga"),
            new printJob("shiva"),
            new printJob("vishnu"),
            new printJob("lakshmi"),
            new printJob("brahma"),
            new printJob("saraswati")
        };
         
        ExecutorService service = Executors.newFixedThreadPool(3);

        for(printJob job : jobs)
        {
           service.submit(job);
        }

        service.shutdown();
    }
    
}
