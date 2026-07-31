package com.advanced.innerClass.anonymousInnerclasses.example1;

public class anonymousInnerclass {

    /*
     * Sometimes we can declare inner class without name such type of inner classes are called 
     * anonymous inner classes 
     * Anonymous Inner class that extends class 
     * Anonymous Inner class that implements Interface 
     * Anonymous Inner class that is defined inside arguments
     * A normal java class can extends only one class at a time of course anonymous inner class also 
     * can extends only one class at a time 
     * A normal java class can implements any number of interfaces simultaneously but anonymous inner 
     * class can implments only one interface at a time
     * A normal class can extends a class and implements any number of interfaces simultaneously 
     * but anonymous inner class can extends a class or can implements an interface but not both simultaneously
     * In inner classes we cant declare any static members but in static nested classes we can decalre static members 
     * including main method hence we can invoke static nested class directly from command prompt
     */

    public static void main(String[] args)
    {
        protein pr = new protein()
        {
           public void type()
           {
             System.out.println("Plant protein");
           }
        };
        /*here overriding takes place*/
        pr.type();
 

    }
    
}
