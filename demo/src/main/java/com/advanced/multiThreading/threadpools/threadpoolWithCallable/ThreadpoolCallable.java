package com.advanced.multiThreading.threadpools.threadpoolWithCallable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadpoolCallable {

    public static void main(String[] args) throws Exception
    {
        MyCallable[] calls = {

            new MyCallable(10),
            new MyCallable(20),
            new MyCallable(30),
            new MyCallable(40),
            new MyCallable(50),
            new MyCallable(60)
        };

        ExecutorService service = Executors.newFixedThreadPool(3);

        for(MyCallable call: calls)
        {
            Future<Integer> f = service.submit(call);
            System.out.println(f.get());

        }

        service.shutdown();
    }
    
}
