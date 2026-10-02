package com.exceptionHandling.specialCases;

public class specialCaseOne {

 


    public static void main(String[] args) {
       
        /*throw new Exception();
        case 1.In the below example Exception is achecked exception so that we must handle it else we will get below compile time error
    error: unreported exception Exception; must be caught or declared to be thrown*/

        throw new Error();
             /*case 2.In the second case Error is an unchecked exception so that we don't need to handle it but we will run-time error due to unchecked 
      Exception*/
      
    }

 
    
}
