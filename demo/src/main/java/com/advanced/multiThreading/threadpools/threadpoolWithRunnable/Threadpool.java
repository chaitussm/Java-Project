package com.advanced.multiThreading.threadpools.threadpoolWithRunnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Threadpool {

    public static void main(String[] args)
    {
        PrintJob[] jobs = {
            new PrintJob("durga"),
            new PrintJob("shiva"),
            new PrintJob("vishnu"),
            new PrintJob("lakshmi"),
            new PrintJob("brahma"),
            new PrintJob("saraswati")
        };
         
        ExecutorService service = Executors.newFixedThreadPool(3);

        for(PrintJob job : jobs)
        {
           service.submit(job);
        }

        service.shutdown();
    }
    
}
