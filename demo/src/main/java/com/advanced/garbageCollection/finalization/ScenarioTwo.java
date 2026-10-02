package com.advanced.garbageCollection.finalization;

public class scenarioTwo {

    public static void main(String[] args) throws Throwable {

        scenarioTwo obj = new scenarioTwo();

        obj.finalize();
        obj.finalize();

        obj = null;
        System.gc(); // Suggesting garbage collection

        System.out.println("End of main method");
    }

    public void finalize(){
        System.out.println("finalize method called");
    }
    
}
