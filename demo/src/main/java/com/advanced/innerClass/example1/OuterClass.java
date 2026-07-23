package com.advanced.innerClass.example1;

public class OuterClass{

    /* 
     * Inner classes is introduced in 1.1 version to fix GUI bugs as the part of event handling. 
     * But beacuse of powerful features and benfits of inner classes slowly 
     * programmers started using in regular coding also
     * Without existing one type of object if there is no chance of existing another type of object 
     * Then we should go for inner classes 
     * Based on position of declaration and behaviour all inner classes are divided into 4 types 
     * Normal or Regualr Inner classes: If we are declaring any named class directly inside the class without static modifier.
     * Method local Inner classes : 
     * Anonymous Inner classes 
     * Static nested classes
     

    */
       private String secret = "Hello from Outer Class!";

   class InnerClasses
   {
        void display() {
            // Can access private members of the outer class directly
            System.out.println(secret);
        }
    }

    
}



