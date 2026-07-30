package com.advanced.innerClass.anonymousInnerclasses.example1;

public class anonymousInnerclass {

    /*
     * Sometimes we can declare inner class without name such type of inner classes are called 
     * anonymous inner classes 
     * Anonymous Inner class that extends class 
     * Anonymous Inner class that implements Interface 
     * Anonymous Inner class that is defined inside arguments
     * 
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
