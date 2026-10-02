package com.advanced.garbageCollection.finalization;

public class ScenarioThree {

    static ScenarioThree s; 

    public static void main(String[] args) throws Exception{
       ScenarioThree  s1 = new ScenarioThree();

       System.out.println("Before nullifying hashcode of s1 is : " + s1.hashCode());
        s1 = null;
        System.gc(); // Suggesting garbage collection

        Thread.sleep(5000); // Giving some time for garbage collection to occur
        
        System.out.println("After nullifying s1 and suggesting GC, " + s.hashCode());

        s = null;

        System.gc(); // Suggesting garbage collection after nullifying s
        Thread.sleep(10000); // Giving some time for garbage collection to occur
        System.out.println("End of main method");

    }
    
    @Override
    protected void finalize() {
        System.out.println("finalize method called");
        s = this; // Resurrection of the object
    }
}
