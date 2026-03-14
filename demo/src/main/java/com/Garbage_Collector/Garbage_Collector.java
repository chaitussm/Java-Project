package com.Garbage_Collector;

public class Garbage_Collector {

    public void finalize()
    {
        System.out.println("Garbage collected:");
    }
    
    public static void main(String[] args) {
        // Create an object and assign it to a reference variable
        Garbage_Collector obj1 = new Garbage_Collector();

        // Create another object and assign it to the same reference variable
        Garbage_Collector obj2 = new Garbage_Collector();

        // At this point, the first object ("Object 1") is no ler referenced and becomes eligible for garbage collection

        // Suggesting the JVM to run the garbage collector (not guaranteed)
        System.gc();

        // Wait for a moment to allow the garbage collector to run
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("End of main method.");
    }
}