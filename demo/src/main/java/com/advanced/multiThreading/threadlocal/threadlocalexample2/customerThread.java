package com.advanced.multiThreading.threadlocal.threadlocalexample2;

public class customerThread extends Thread{

    static Integer custId = 0;

    private static ThreadLocal<Integer> tl = new ThreadLocal<Integer>()
    {
        protected Integer initialValue()
        {
            return ++custId;
        }
    };

    customerThread(String name)
    {
        super(name);
    }
    
    public void run()
    {
        System.out.println(Thread.currentThread().getName()+ "executing with cutomer ID :" + tl.get());
    }
}
