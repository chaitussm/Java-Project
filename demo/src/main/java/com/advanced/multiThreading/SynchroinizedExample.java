package com.advanced.multiThreading;

public class SynchroinizedExample extends Thread {

        Display d;
        String name;
        SynchroinizedExample(Display d,String name)
        {
            this.name = name;
            this.d = d; 
        }
        
        public void run()
        {
            d.wish(name);
        }
    
    public static void main(String[] args) {
        
        Display d  = new Display();
        SynchroinizedExample de = new SynchroinizedExample(d, "Dhoni");
        SynchroinizedExample de1 = new SynchroinizedExample(d, "Kohli");
        de.start();
        de1.start();
    }
    
}
