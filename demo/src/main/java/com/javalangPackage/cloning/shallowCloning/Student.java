package com.javalangPackage.cloning.shallowCloning;

public class student implements Cloneable{

    /*
     *
     * Shallow Cloning : 
     * The process of creating bit-wise copy of an object is called Shallow cloning.If the main object contains primitive variables 
     * then exactly duplicate copies will be created in the cloned Object. If the main Object contains any reference variable then 
     * corresponding Object won't be created just duplicate reference variable will be created pointing to old contained Object.
     * 
     * Object class clone() meant for Shallow Cloning 
     * 
     * 
     */

     teacher t;

     int j; 

     student(teacher t, int j)
     {
        this.t = t;
        this.j = j;
     }

     public Object clone() throws CloneNotSupportedException
     {
         return super.clone();
     }


    
}
