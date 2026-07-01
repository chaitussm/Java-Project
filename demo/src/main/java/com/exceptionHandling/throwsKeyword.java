package com.exceptionHandling;

public class throwsKeyword {

    /*1.Here when we use throws keyword the caller for the main method id JVM so JVM will be handling t
    he exception to convince compiler
    2. But throws keyword doesnt stops the abnormal termination of the program
    3. throws keyword only required for the usage of checked exception for unchecked exception it wont work
    4. If we have multiple levels of calling methods are there, then we need to declare the exceptions in each method
    5.We can use trhows keyword for methods and constructors but not classes*/

    public static void main(String[] args) throws ArithmeticException {

        System.out.println(10/0); 

        //Thread.sleep(10000); // This will throw InterruptedException, which is a checked exception
        
      
    }
    
      public static void method1() throws InterruptedException {
            Thread.sleep(1000); // This will throw InterruptedException, which is a checked exception
        }
        public static void method2() throws InterruptedException {
            method1(); // Calling method1, which declares that it throws InterruptedException
        }
    
}
