package com.javalangPackage.strings;

public class stringObjectCreationPart1 {

    public static void main(String[] args) {

        String s = new String("Shiva");

        s.concat("Parvathi");

        String s1 = s.concat("Vishnu");

        s = s.concat("Shakti");
      
        System.out.println("s: " + s);
        System.out.println("s1: " + s1);

        /*
         * 
         * In the above example total 5 objects are created 
         * 1. line 7 : 2 objects one heap and one in SCP
         * 2. line 9 : 1 object in SCP, after concating ShivaParvathi but not reference variable eligible for garbage collection
         * 3. line 10 : 1 Object Vishnu is created in SCP and after concating ShivaVishnu object placed in heap memory 
         * 4. line 12 : 1 Object Shakti is created in SCP and after concating ShivaShakti object placed in heap memory
         * 
         */

       

    }
    
}
