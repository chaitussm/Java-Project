package com.javalangPackage.variousMethods;

public class customizedEqualsMethod {

    /*
     *
     *
     * If our class contains equals() method then our class equals() will be executed
     * In the below example we are overriding the equals() method of Object class
     * In the below example we are checking the content of the object instead of reference
     */

    String name;
    int rollno;

    customizedEqualsMethod(String name, int rollno)
    {
       this.name = name;
       this.rollno = rollno;
    }

    public boolean equals(Object o)
    {
        if(o instanceof customizedEqualsMethod)
        {
            /*Here instanceof means checking if the object o is an instance of customizedEqualsMethod */
            customizedEqualsMethod st = (customizedEqualsMethod)o;
            if(this.name.equals(st.name) && this.rollno == st.rollno)
            {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args)
    {
       customizedEqualsMethod st = new customizedEqualsMethod("Shiva", 1);
       customizedEqualsMethod st1 = new customizedEqualsMethod("Shiva", 1);
       customizedEqualsMethod st2 = st;
       customizedEqualsMethod st3 = new customizedEqualsMethod("Parvathi", 2);
       System.out.println(st.equals(st1));
       System.out.println(st.equals(st2));
       System.out.println(st.equals(st3));
       /*In the above examples our class equals() is executed thats why its checking the content of the object instead of reference 
         In the below example if we use null , generally we get NullPointerException because we are trying to access the content of null object, 
         Hence it is recommended to check if the object is null or not before accessing the content of the object , so as per below example 
         we will get false
        */
        System.out.println(st1.equals(null));

        /* String vs StringBuffer vs StringBuilder equals() method
         * String class equals() method is overridden to check the content of the object instead of reference
         * StringBuffer and StringBuilder class equals() method is not overridden to check the content of the object instead of reference,
         *  Hence it is recommended to use String class instead of StringBuffer and String
         */

        String a = new String("Shiva");
        String b = new String("Shiva");
        StringBuffer sb1 = new StringBuffer("Shiva");
        StringBuffer sb2 = new StringBuffer("Shiva");
        System.out.println(a.equals(b)); 
        System.out.println(a==b);
        System.out.println(sb1.equals(sb2)); 
        System.out.println(sb1==sb2);

    }
    
}
