package com.javalangPackage.variousMethods;

public class equalsMethodInObjectClass {

    /*
     *
     *
     * If our class doesnt contains equals() method then Object class equals() will be executed
     */

    String name;
    int rollno;

    equalsMethodInObjectClass(String name, int rollno)
    {
       this.name = name;
       this.rollno = rollno;
    }

    public static void main(String[] args)
    {
       equalsMethodInObjectClass st = new equalsMethodInObjectClass("Shiva", 1);
       equalsMethodInObjectClass st1 = new equalsMethodInObjectClass("Shiva", 1);
       equalsMethodInObjectClass st2 = st;
       equalsMethodInObjectClass st3 = new equalsMethodInObjectClass("Parvathi", 2);
       System.out.println(st.equals(st1));
       System.out.println(st.equals(st2));
       System.out.println(st.equals(st3));
       /*In the above examples Object class equals() is executed thats why its checking only the reference but not the content */
    }
    
}
