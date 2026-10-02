package com.advanced.multiThreading.threadpools.threadpoolWithCallable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class threadpoolCallable {

    public static void main(String[] args) throws Exception
    {
        myCallable[] calls = {

            new myCallable(10),
            new myCallable(20),
            new myCallable(30),
            new myCallable(40),
            new myCallable(50),
            new myCallable(60)
        };

        ExecutorService service = Executors.newFixedThreadPool(3);

        for(myCallable call: calls)
        {
            Future<Integer> f = service.submit(call);
            System.out.println(f.get());

        }

        service.shutdown();
    }
    
}
