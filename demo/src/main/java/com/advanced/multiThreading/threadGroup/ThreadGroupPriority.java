package com.advanced.multiThreading.threadGroup;

public class threadGroupPriority {

    public static void main(String[] args){

        ThreadGroup g1 = new ThreadGroup("Group1");
        Thread t1 = new Thread(g1, "Thread1");
        Thread t2 = new Thread(g1, "Thread2");
        g1.setMaxPriority(3);
        Thread t3 = new Thread(g1,"Group3");
        System.out.println("thread one priority : "+ t1.getPriority());
        System.out.println("thread two priority : " + t2.getPriority());
        System.out.println("thread three priority is : " + t3.getPriority());

      
    }
    
}
