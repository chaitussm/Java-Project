package com.advanced.multiThreading.threadpools.threadpoolWithCallable;

import java.util.concurrent.Callable;

public class myCallable implements Callable{
    
    int num;

    myCallable(int  num)
    {
       this.num= num;
    }
    
    public Object call() throws Exception
    {
       System.out.println(Thread.currentThread().getName() + " is..responsible to find the sum of first " + num + "numbers");
       int sum = 0;
       for(int i = 0 ; i<= num ; i++)
       {
          sum += i;
       }
       return sum;
    }
}
