package com.advanced.multiThreading;

public class synchroinizedExample extends Thread {

        display d;
        String name;
        synchroinizedExample(display d,String name)
        {
            this.name = name;
            this.d = d; 
        }
        
        public void run()
        {
            d.wish(name);
        }
    
    public static void main(String[] args) {
        
        display d  = new display();
        synchroinizedExample de = new synchroinizedExample(d, "Dhoni");
        synchroinizedExample de1 = new synchroinizedExample(d, "Kohli");
        de.start();
        de1.start();
    }
    
}
