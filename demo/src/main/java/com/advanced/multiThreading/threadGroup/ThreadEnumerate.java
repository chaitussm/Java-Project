package com.advanced.multiThreading.threadGroup;

public class threadEnumerate {

    public static void main(String[] args)
    {
        ThreadGroup g1 = new ThreadGroup("Group1");
        Thread[] t1 = new Thread[10];
        int length = g1.enumerate(t1);

        for(int i = 0; i<= length ; i++)
        {
            System.out.println("Threads are :" + i);
        }

         

    }
    
}
