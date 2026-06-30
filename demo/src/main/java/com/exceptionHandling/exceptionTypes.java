package com.exceptionHandling;

import java.io.PrintWriter;

public class exceptionTypes {
/*Exceptions which are checked by compiler for the smooth execution of the program at run time these exceptions are checked Exceptions
  
In the belwo we have handle the execption using throws keyword in the main method. If we don't handle the exception using throws keyword then we will get a compile time error.

then we get error like below:
Error: Unreported exception Exception; must be caught or declared to be thrown
*/
 public static void main(String[] args) throws Exception {
      PrintWriter pw = new PrintWriter("abc.txt");
      pw.println("Hello");

    }

/*Exception which are not checkd by compiler if programmmer handling or not are called unchecked exceptions
 Arithmetic exception 
 Error and its child classes are unchecked exceptions Except thse remaining are checked exceptions*/
 /*The only possible partially checked exceptions in java are 
 1.Exception
 2.Throwable*/
}
