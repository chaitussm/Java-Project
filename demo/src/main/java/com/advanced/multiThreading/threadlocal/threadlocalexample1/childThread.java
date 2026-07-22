package com.advanced.multiThreading.threadlocal.threadlocalexample1;

public class childThread extends Thread{

    public void run()
    {
        System.out.println("child thread value --:" + parentThread.l.get());
    }
    
}
