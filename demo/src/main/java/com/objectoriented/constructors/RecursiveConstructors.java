package com.objectoriented.constructors;

public class RecursiveConstructors {

   
    //NOTE
    //1.Recursive constructor is a constructor which is calling itself directly or indirectly
    //2.Recursive constructor is not allowed in java because if we are calling the constructor recursively
    //3. If we uncomment the this() and try to execute compiler will give recursive constructor invocation error 
      RecursiveConstructors()
    {
        //this(10);
    }
    
     RecursiveConstructors(int i)
    {
        //this();
    }
    
    
    public static void main(String[] args) {
       
       System.out.println("Hello");
    }
}
