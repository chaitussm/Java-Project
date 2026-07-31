package com.advanced.innerClass.nestedClassesAndInterfaces;

// Outer Interface
interface Vehicle {
    void start();

    // Inner Interface (Nested Interface)
    // Implicitly public and static by default
    interface GPS {
        void navigateTo(String destination);
    }
}

// A class implementing ONLY the inner interface
class SmartPhone implements Vehicle.GPS {
    @Override
    public void navigateTo(String destination) {
        System.out.println("Phone navigating to: " + destination);
    }
}
 

public class interfaceInsideInterface {

    /*
     *
     *
     * we can decalare interface inside interface 
     * ex: A Map is a group of Key, value pairs and each key value pair is called an Entry 
     * without existing map object there is no chance of existing entry object, hence 
     * interface entry is defined inside map interface
     * The interface which is declared inside a class is always static but need not to be public 
     * 
    */
     public static void main(String[] args) {
        // Accessing the inner interface via the outer interface name
        Vehicle.GPS myGps = new SmartPhone();
        myGps.navigateTo("Central Park");
    }

    
}
