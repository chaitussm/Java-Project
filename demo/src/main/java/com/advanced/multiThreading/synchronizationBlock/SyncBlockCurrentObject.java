package com.advanced.multiThreading.synchronizationBlock;

/*If very few lines of code requires synchronization then it is not recommended to use entire 
synchronized method or block, we have to enlose those few lines of the code under a synchronized block 
belwo example for current object sync block */

public class SyncBlockCurrentObject extends Thread {

    DisplaySync d;
    String name;

    SyncBlockCurrentObject(DisplaySync d, String name) {
        this.d = d;
        this.name = name;
    }

    public void run() {
        
      d.wish(name);
        
    }
    
    public static void main(String[] args) {
        DisplaySync d1 = new DisplaySync();
        DisplaySync d2 = new DisplaySync();
        SyncBlockCurrentObject t1 = new SyncBlockCurrentObject(d1, "Dhoni");
        SyncBlockCurrentObject t2 = new SyncBlockCurrentObject(d2, "Kohli");
        /*Here current object lock is applied thats why t1 static object is executed first
        followed by t2 static object */
        t1.start();
        t2.start();
    }
    
    
}
