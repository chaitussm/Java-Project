package com.objectoriented.constructors;

public class constructorErrorInheritedClasses extends defaultConstructor{

    //NOTE 
    //Very important example to understand the default constructor and its behavior in inheritance.

    //Scenario1 
    // lets say we havent created cconstrutor in both of the above classes code will be compiled properly.

    //Scenario2
    // lets say we have created constructor in defaultConstructor class but not in constructorError class t
    //compiler will generate deafult constructor in constructorError class in the below format 
    /*
    constructorError()
    {
        super();
    }
     */

    //Scenario3
    // lets say we have created constructor in defaultConstructor class like below 
    /*
    defaultConstructor(int a)
    {
        System.out.println("Default constructor is called");
    }
     */ 
  
    //then automatically we may get compile time error saying 
    /*cannot find symbol constructor defaultConstructor() 
      
    symbol: constructor defaultConstructor()
    location: class com.objectoriented.constructors.defaultConstructor
    */
    //
    public static void main(String[] args) {
        System.out.println("Constructor basics");
    }


    
}
