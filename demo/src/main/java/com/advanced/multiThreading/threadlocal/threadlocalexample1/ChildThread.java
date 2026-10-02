package com.advanced.multiThreading.threadlocal.threadlocalexample1;

public class ChildThread extends Thread{

    public void run()
    {
        System.out.println("child thread value --:" + ParentThread.l.get());
    }
    
}
