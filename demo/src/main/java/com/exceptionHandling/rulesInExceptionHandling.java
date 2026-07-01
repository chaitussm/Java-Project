package com.exceptionHandling;

public class rulesInExceptionHandling {
    /*
    1.Two catch blocks with the same exception type is not allowed if we try to use it we will get belwo exception 

    Error: exception java.lang.Exception has already been caught
    2. try followed by finally is avalid syntax
    */
    
    public static void main(String[] args) {
        int c = 0;
        try {
            c = 10 / 0;
            System.out.println(c);
      
        } finally {
            c = 10;
            System.out.println("Final value of c: " + c);
        }
    }

    /*In the above example program may be abnormal execution but finally block 
    is having the clean up code so that c value is changed
    3. only try block and onlt catch block is not allowed if we try to complile it we get below error 
    error: 'try' without 'catch', 'finally' or resource declarations
    4. If we use try finally and catch block we will get below error
    error: 'catch' without 'try'
    5. We are not allowed to any print statement in between try catch or finally block if we try to do so we will get below error
    error: 'try' without 'catch', 'finally' or resource declarations
    6.For try catch and finally blocks {} are mandatory if we don't use it we will get below error
    error: 'try' without 'catch', 'finally' or resource declarations
    */
    
}
