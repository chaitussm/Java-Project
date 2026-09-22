package com.advanced.garbageCollection.finalization;

public class scenarioFour {

    static int count = 0;

    public static void main(String[] args) {
        
        /*for(int i = 0; i < 10; i++) {
            if we increase the number of iterations, we can observe more calls to the finalize method.
            at certain point memory might get exhausted and garbage collection will be triggered.
            Then jvm runs gc calls finalize() method separately for each eligible object and destroys it
            scenarioFour sc = new scenarioFour();   
            sc = null; // Making the object eligible for garbage collection
        }
        */ 
    }

    public void finalize() {
        count++;
        System.out.println("Finalize method called " + count + " times");
    }
}
    

