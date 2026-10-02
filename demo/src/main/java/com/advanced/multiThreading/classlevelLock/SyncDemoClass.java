package com.advanced.multiThreading.classlevelLock;

public class syncDemoClass extends Thread {

    democlass d;
    String name;

    syncDemoClass(String name, democlass d) {
        this.name = name;
        this.d = d;
    }

    public void run() {
        d.wish(name);
    }

    public static void main(String[] args) {
        democlass d1 = new democlass();
        democlass d2 = new democlass();
        syncDemoClass t1 = new syncDemoClass("Dhoni", d1);
        syncDemoClass t2 = new syncDemoClass("Kohli", d2);
        /*Here class level lock is applied thats why t1 static object is executed first
        followed by t2 static object */
        t1.start();
        t2.start();
    }
    
}
