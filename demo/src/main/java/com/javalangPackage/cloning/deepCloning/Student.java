package com.javalangPackage.cloning.deepCloning;

public class Student implements Cloneable{

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

     Teacher t;

     int j; 

     Student(Teacher t, int j)
     {
        this.t = t;
        this.j = j;
     }

     public Object clone() throws CloneNotSupportedException
     {
         Teacher t1 = new Teacher(t.i);
         Student s = new Student(t1, j);
         return s;
     }


    
}
