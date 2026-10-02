package com.javalangPackage.strings.stringObjectsCreation;

public class stringObjects {

    public static void main(String[] args)
    {
        String s1 = new String("you cannot change me");

        String s2 = new String("you cannot change me");

        /* For the above 2 example 3 objects will be created 
         * 2 separate objects in heap area for s1 ans s2 
         * 1 in SCP area referenced by s1 , once the object is created in SCP again it wont be created but it is referenced by s2 also 
         */

        System.out.println(s1==s2); 

        String s3 = "you cannot change me";

        // Here only one object is created in the SCP area 

        System.out.println(s1==s3);

        String s4 = "you cannot change me";

        // Since already s3 is having same object s4 also points to the same object 

        System.out.println(s3==s4);

        String s5 = "you cannot" + "change me";

        /*
         * no object will be created "you cannot" , "change me" are constants 
         * If both are compile time constants this operation will be perfomed at compile time only 
         * At compile time the whole line will be "you cannot change me"
         * Hence s5 also points towards the same s3 and s4 
         */
        
        System.out.println(s3 == s5);

        String s6 = "you cannot";

        /*
         * "you cannot" is a constant and it is created in SCP area 
         */

        String s7 = s6 + "change me";

        /*
         * s6 is a normal variable and it may change and reassignment also possible , "change me" is a constant only 
         * if atleast 1 argument is a normal variable then the operation is performed at runtime only nor in compile time 
         * for "change me" one object is created in SCP area 
         * At runtime if an object is performed compulsory that object is created in heap area 
         * s7 is pointing towards "you cannot change me"
         */

        System.out.println(s3 == s7);

        final String s8 = "you cannot";

        String s9 = s8 + "change me ";

        /*
         * s8 is pointing to the same object which is already present for s6
         * Here s8 is constant beacuse it is decalred as final so constant + constant 
         * so the operation is performed at compile time only 
         * s9 is also pointing to the same object which is pointed by s3,s4,s5
         */

        System.out.println(s3 == s8);

        System.out.println(s6==s8);



    }
    
}
