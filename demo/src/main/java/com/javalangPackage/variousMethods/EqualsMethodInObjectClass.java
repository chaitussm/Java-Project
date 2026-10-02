package com.javalangPackage.variousMethods;

public class EqualsMethodInObjectClass {

    /*
     *
     *
     * If our class doesnt contains equals() method then Object class equals() will be executed
     */

    String name;
    int rollno;

    EqualsMethodInObjectClass(String name, int rollno)
    {
       this.name = name;
       this.rollno = rollno;
    }

    public static void main(String[] args)
    {
       EqualsMethodInObjectClass st = new EqualsMethodInObjectClass("Shiva", 1);
       EqualsMethodInObjectClass st1 = new EqualsMethodInObjectClass("Shiva", 1);
       EqualsMethodInObjectClass st2 = st;
       EqualsMethodInObjectClass st3 = new EqualsMethodInObjectClass("Parvathi", 2);
       System.out.println(st.equals(st1));
       System.out.println(st.equals(st2));
       System.out.println(st.equals(st3));
       /*In the above examples Object class equals() is executed thats why its checking only the reference but not the content */
    }
    
}
