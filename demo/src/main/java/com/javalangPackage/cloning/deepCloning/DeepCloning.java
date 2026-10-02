package com.javalangPackage.cloning.deepCloning;

public class deepCloning implements Cloneable{

    /*
     * Deep Cloning 
     * the process of creating exactly duplkicate independent copy including contained object is called deep cloning 
     * In deep cloning if the main object contains any primitive variables then in the cloned object dupliacte copies will be created 
     * If the main object contains any reference variable then the corresponding contained objects will also be created in the cloned copy
     * By default object class clone method meant for shallow cloning but we cna implement explicitly by overriding clone() in out class 
     */
    
    public static void main(String[] args) throws CloneNotSupportedException
    {
        teacher t = new teacher(20);
        student s = new student(t, 30);
     
        System.out.println(s.j + "----" + s.t.i);

        student t1 = (student)s.clone();

        t1.j = 888;
        t1.t.i = 999;

        System.out.println(t1.j + "====" + t1.t.i);

        /*
         * Which cloning is best
         * If object contains only primitive variables then shallow cloning is the best choice 
         * If object contains reference variables then deep cloning is the best choice
         */
    
    }
}
