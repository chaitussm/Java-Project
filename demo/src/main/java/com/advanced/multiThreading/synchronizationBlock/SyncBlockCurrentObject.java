package com.advanced.multiThreading.synchronizationBlock;

/*If very few lines of code requires synchronization then it is not recommended to use entire 
synchronized method or block, we have to enlose those few lines of the code under a synchronized block 
belwo example for current object sync block */

public class syncBlockCurrentObject extends Thread {

    displaySync d;
    String name;

    syncBlockCurrentObject(displaySync d, String name) {
        this.d = d;
        this.name = name;
    }

    public void run() {
        
      d.wish(name);
        
    }
    
    public static void main(String[] args) {
        displaySync d1 = new displaySync();
        displaySync d2 = new displaySync();
        syncBlockCurrentObject t1 = new syncBlockCurrentObject(d1, "Dhoni");
        syncBlockCurrentObject t2 = new syncBlockCurrentObject(d2, "Kohli");
        /*Here current object lock is applied thats why t1 static object is executed first
        followed by t2 static object */
        t1.start();
        t2.start();
    }
    
    
}
