package com.advanced.multiThreading.threadlocal.threadlocalexample1;

public class parentThread extends Thread{

    /*If we use InheritableThreadLocal then the value given to parent thread will be inherited to child thread also
    We can give our own value for child Thread also*/

    //static ThreadLocal<String> l = new ThreadLocal<String>();

    //static InheritableThreadLocal<String> l = new InheritableThreadLocal<String>();

    static InheritableThreadLocal<Object> l = new InheritableThreadLocal<Object>()
    {
        public Object childValue(Object p)
        {
            return "child";
        }
    };



    public void run()
    {
        l.set("parent");
        System.out.println("Parent Thread value---" + l.get());
        childThread ch = new childThread();
        ch.start();
    }
    
}
