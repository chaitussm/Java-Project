package com.javalangPackage.cloning.shallowCloning;

public class shallowCloningDemo {

    public static void main(String[] args) throws CloneNotSupportedException
    {
        teacher t = new teacher(20);
        student s = new student(t, 30);
        System.out.println(s.j + "----" + s.t.i);

        student t1 = (student)s.clone();

        t1.j = 50; // student Object j is updated for cloned object 
        t1.t.i = 55; // student Object with teacher reference also changed because no new refernce is created and pointing to older reference only 

        System.out.println(t1.j + "----" + t1.t.i);
        
        /*
         *
         * In shallow cloning by using cloned object ereference if we perform any change to the contained object then 
         * those changes will be reflected to the main object  
         * To overcome this problem we should go for deep cloning
         */

    }
    
}
