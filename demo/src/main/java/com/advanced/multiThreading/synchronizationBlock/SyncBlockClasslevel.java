package com.advanced.multiThreading.synchronizationBlock;
import com.advanced.multiThreading.Display;

/*race condition means multiple threads trying to access the same resource simultaneously 
statements present in synchronized method and synchronized block are called synchronized statements */

public class SyncBlockClasslevel extends Thread {
    
    static Display d;
    String name;
    
    SyncBlockClasslevel(Display d, String name) {
        this.d = d;
        this.name = name;
    }
    
    public void run() {
        synchronized (Display.class) {
            d.wish(name);
        }
    }
    
    public static void main(String[] args) {
        Display d1 = new Display();
        Display d2 = new Display();
        SyncBlockClasslevel t1 = new SyncBlockClasslevel(d1, "Dhoni");
        SyncBlockClasslevel t2 = new SyncBlockClasslevel(d2, "Kohli");
        /*Here class level lock is applied thats why t1 static object is executed first
        followed by t2 static object */
        t1.start();
        t2.start();
    }
    
}
