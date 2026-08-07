package com.javalangPackage.strings;

public class StringObjectCreation {

    public static void main(String[] args) {
       
        /*
         * 
         *
         * In the below example 2 objects will be created one in the heap memory and another in the string constant pool
         * and st is always pointing to the heap object
         * NOTE : Object creation in SCP is optional first it will check is there any object already present in SCP with required content
         * if object already present then existing object will be reused if object is not already available then only new object will be created in SCP
         * garbage collector is not eligible for objects created in SCP hence they will be available throughout the application life cycle 
         * because garbage collector is applicable for heap memeory but SCP is present in the Method area of JVM
         * All SCP objects are destroyed at the time of JVm shutdown.
         * 
         */

        String st = new String("Shiva"); 

        String st1 = new String("Shiva");


        /*
         *
         * In the below example only one object will be created in the string constant pool and s will point to that object
         * 
         */

        String s = "Shiva";
        String s1 = "Shiva";

        // In the above examples only 2 objects will be created in heap area but one object got created in SCP and it will reused for s1 beacuse no duplicate 
        // object will be created in SCP.

        //java program to get the number of objects are created in the heap memory and string constant pool at runtime 

        System.out.println("Hashcode of st: " + st.hashCode());
        System.out.println("Hashcode of st1: " + st1.hashCode());
        System.out.println("Hashcode of s: " + s.hashCode());
        System.out.println("Hashcode of s1: " + s1.hashCode()); 
    }
    
}
