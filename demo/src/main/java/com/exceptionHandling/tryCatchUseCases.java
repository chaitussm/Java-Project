package com.exceptionHandling;

public class tryCatchUseCases {
    /*  NOTE
    1. The try block is used to enclose the code that may throw an exception.
    2. The catch block is used to handle the exception thrown by the try block.
    3. The finally block is used to execute code that must run regardless of whether an exception occurred or not.
    4. The finally block is optional, but it is often used for cleanup operations like closing files or releasing resources.
    */
    public static void main(String[] args) {

        try{
            sayHi();
            riskyOperation();
            sayHello();
        }
        catch(Exception e){
           handleException(e); 

        }

        cleanup();
    }

    public static void sayHi() {
        System.out.println("Hi");
        sayHello();
    }

    public static void sayHello() {
        System.out.println("Hello");
    }

    public static void riskyOperation() {
        // Code that may throw an exception
    }

    public static void cleanup() {
        // Code that must run regardless of whether an exception occurred or not
    }

    public static void handleException(Exception e) {
        // Code to handle the exception
    }

    /*
    Case 1: If no exception is not avaiable the common flow will be skipping the catch block
    Case 2: If there is an exception in try block exactly riskyOperation() then control goes to catch block 
    then it wont goes back to try block and it contnues the code aftre the catch block thats why dont take normal code inside the try block
    Case 3: mlets say we have risky code at sayHello(); and we dont have required exception name in catch block then it statement above the risky copde will be executed and then program will be stopped abnormally.
    Case 4: In addition to try block there may be a chance of raising an exception inside catch and finally blocks 
    Case 5: If any statement which is not a part of try block and rises an exception then it is always abnormal termination
    
    */
}
