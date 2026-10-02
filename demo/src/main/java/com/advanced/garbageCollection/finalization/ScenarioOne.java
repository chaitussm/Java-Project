package com.advanced.garbageCollection.finalization;

public class ScenarioOne {

    public static void main(String[] args) {
        
        //String obj = new String("durga");

        ScenarioOne obj = new ScenarioOne();
        // by commenting this only main method thread is executed for String Object finalize() is called , 
        // finalize() method will not be called for ScenarioOne object
        
        obj = null;

        System.gc();

        System.out.println("End of Main Method");

    }

    public void finalize() {
        System.out.println("Finalize method called");
    }
    
}
