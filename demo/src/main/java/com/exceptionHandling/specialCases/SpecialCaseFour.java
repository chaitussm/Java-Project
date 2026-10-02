package com.exceptionHandling.specialCases;

import java.io.IOException;

/*throw : to handover our created exception  object to JVM manually 
throws : to delegate responsibility of handling exception to the caller*/

public class specialCaseFour {

    public static void main(String[] args) {
        
        /*try{

            System.out.println("Fully checked exception");
        }
        catch (IOException e){
            System.out.println("Exception occured");
        }

       
       try{
            System.out.println("Fully checked exception");
           }
        catch(InterruptedException e){
            System.out.println("Exception occured");
        }
     In the above example, both InIOException and InterruptedException are fully checked exceptions and must be handled at compile time*/
         
    }
    
}
