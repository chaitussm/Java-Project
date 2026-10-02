package com.exceptionHandling;

public class waysOfPrintingException {

     public static void calculation()
    {
        try
        {
            int c = 10/0;
            System.out.println(c);
        }
        catch(Exception e)
        {
            /* If we want complete details Error name, description 
            and location of the exception occured */
            
            e.printStackTrace();
            
            /*If we want only description and Error name*/
            
            System.out.println(e);
            
            /*If we want only the description of error*/
            
            System.out.println(e.getMessage());
            
            
        }
    }
    
  
    public static void main(String[] args) {
      
      calculation();
    }
    
}
