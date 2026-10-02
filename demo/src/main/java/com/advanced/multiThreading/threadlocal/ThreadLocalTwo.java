package com.advanced.multiThreading.threadlocal;

public class threadLocalTwo {

    public static void main(String[] args)
    {
        ThreadLocal<Object> local = new ThreadLocal<Object>()
        {
            public Object initialValue()
            {
                return "abc";
            }
        };
        System.out.println(local.get());
        local.set("durga");
        System.out.println(local.get());
        local.remove();
        System.out.println(local.get());
    }
    
}
