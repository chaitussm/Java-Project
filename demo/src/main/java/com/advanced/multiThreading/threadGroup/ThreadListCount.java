package com.advanced.multiThreading.threadGroup;

public class ThreadListCount {

    public static void main(String[] args) throws InterruptedException
    {
        /*In this example main group is 
        System => main => Parent Group => ChildGroup , ChildThread1, ChildThread2*/
        ThreadGroup g = new ThreadGroup("Parent group");
        ThreadGroup g1 = new ThreadGroup(g, "Child group");
        MyThread t1 = new MyThread(g1, "Child Thread");
        MyThread t2 = new MyThread(g1, "Child Thread");
        t1.start();
        t2.start();
        System.out.println(g.activeCount());
        System.out.println(g.activeGroupCount());
        g.list();
        Thread.sleep(10000);
        System.out.println(g.activeCount());
        System.out.println(g.activeGroupCount());
        g.list();
        
        /*Enumerator */
        ThreadGroup system = Thread.currentThread().getThreadGroup().getParent();

        Thread[] t = new Thread[system.activeCount()];

        system.enumerate(t);

        for(Thread thread : t)
        {
            System.out.println(thread.getName() + "=====" + thread.isDaemon());
        }


    }
    
}
