package com.advanced.multiThreading.classlevelLock;

public class SyncDemoClass extends Thread {

    Democlass d;
    String name;

    SyncDemoClass(String name, Democlass d) {
        this.name = name;
        this.d = d;
    }

    public void run() {
        d.wish(name);
    }

    public static void main(String[] args) {
        Democlass d1 = new Democlass();
        Democlass d2 = new Democlass();
        SyncDemoClass t1 = new SyncDemoClass("Dhoni", d1);
        SyncDemoClass t2 = new SyncDemoClass("Kohli", d2);
        /*Here class level lock is applied thats why t1 static object is executed first
        followed by t2 static object */
        t1.start();
        t2.start();
    }
    
}
