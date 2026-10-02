package com.javalangPackage.cloning.shallowCloning;

public class ShallowCloningDemo {

    public static void main(String[] args) throws CloneNotSupportedException
    {
        Teacher t = new Teacher(20);
        Student s = new Student(t, 30);
        System.out.println(s.j + "----" + s.t.i);

        Student t1 = (Student)s.clone();

        t1.j = 50; // Student Object j is updated for cloned object 
        t1.t.i = 55; // Student Object with Teacher reference also changed because no new refernce is created and pointing to older reference only 

        System.out.println(t1.j + "----" + t1.t.i);
        
        /*
         *
         * In shallow cloning by using cloned object ereference if we perform any change to the contained object then 
         * those changes will be reflected to the main object  
         * To overcome this problem we should go for deep cloning
         */

    }
    
}
