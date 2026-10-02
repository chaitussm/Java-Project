package com.exceptionHandling;

public class abnormalFlowNoExceptionHandling {
/* NOTE
1. An unwanted and unexpected event that disturbs the normal flow of the program is called an exception.
2. The main objective of exception handling is to handle exceptions and allow graceful termination without disrupting normal program flow.
3. Another objective is to provide alternatives that allow the program to continue executing after an exception occurs.
4. If an exception occurs in a method, that method is responsible for creating an exception object that contains:
       - Name:        Exception name
       - Description: Description of the exception
       - Location:    Location where the exception occurred
5. The JVM then searches the call stack for an appropriate exception handler; if none is found, it unwinds the stack and terminates the program abnormally.
6. In this case the JVM's default exception handler prints the exception information to the console in a format like:
       Exception in thread "main" java.lang.ArithmeticException: / by zero
               at com.exceptionHandling.basics.main(basics.java:10)
*/

public static void main(String[] args) {
       
       sayHi();
       System.out.println(10/0);
    }
    
    public static void sayHi()
    {
        System.out.println("Hi");
        sayHello();
    }
    
    public static void sayHello()
    {
        System.out.println("Hello");
    }
}
