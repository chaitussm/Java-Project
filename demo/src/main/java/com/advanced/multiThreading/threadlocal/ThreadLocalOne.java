package com.advanced.multiThreading.threadlocal;

public class threadLocalOne {

    public static void main(String[] args)
    {
        ThreadLocal<String> local = new ThreadLocal<String>();
        System.out.println(local.get());
        local.set("durga");
        System.out.println(local.get());
        local.remove();
        System.out.println(local.get());



    }
    
}
