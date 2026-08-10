package com.javalangPackage.autoboxingAndAutoUnBoxing;

public class autoBoxingexample1 {

    static Integer I = 0;
     
    static Integer I1 ;

    public static void main(String[] args)
    {
        int m = I ;
        System.out.println(m);

        int n = I1;
        /*System.out.println(n); If we execute this line internally 
          int n = I.intValue() will be executed but the dfault value for the static Integer Object is null 
          thats why we get the NullPointerException
        */

    }
    
}
