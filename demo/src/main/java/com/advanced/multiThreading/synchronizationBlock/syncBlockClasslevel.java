package com.advanced.multiThreading.synchronizationBlock;
import com.advanced.multiThreading.display;

/*race condition means multiple threads trying to access the same resource simultaneously 
statements present in synchronized method and synchronized block are called synchronized statements */

public class syncBlockClasslevel extends Thread {
    
    static display d;
    String name;
    
    syncBlockClasslevel(display d, String name) {
        this.d = d;
        this.name = name;
    }
    
    public void run() {
        synchronized (display.class) {
            d.wish(name);
        }
    }
    
    public static void main(String[] args) {
        display d1 = new display();
        display d2 = new display();
        syncBlockClasslevel t1 = new syncBlockClasslevel(d1, "Dhoni");
        syncBlockClasslevel t2 = new syncBlockClasslevel(d2, "Kohli");
        /*Here class level lock is applied thats why t1 static object is executed first
        followed by t2 static object */
        t1.start();
        t2.start();
    }
    
}
