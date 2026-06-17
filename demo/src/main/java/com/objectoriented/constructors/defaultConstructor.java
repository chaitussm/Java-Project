package com.objectoriented.constructors;

public class defaultConstructor {

//NOTE
 
//1.Compliere is responsible to generate the dafault constructor
//2,If we dont provide ant single constructor then only compiler will genrate the default constructor
//3.If we provide any constructor then compiler will not genrate the default constructor
//4.Default constructor is a no argument constructor and it will call the super class default constructor
//5.Default constructor is used to create the object of the class and it will initialize the instance variables with default values

defaultConstructor()
{
    
}
    public static void main(String[] args) {
        
        defaultConstructor obj = new defaultConstructor();
        System.out.println("Default constructor is called");

    }   

    
}
