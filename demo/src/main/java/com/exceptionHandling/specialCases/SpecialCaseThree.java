package com.exceptionHandling.specialCases;

public class specialCaseThree {

    public static void main(String[] args) {
      /*Both ArithmeticException and Error are unchecked exceptions so no compile time errors*/

      try
      {
        System.out.println("Unchecked Exception");
      }

      catch(ArithmeticException e)
      {
        System.out.println("Exception occured");
      }

      catch(Error e)
      {
        System.out.println("Error occured");
      }
    }
    
}
