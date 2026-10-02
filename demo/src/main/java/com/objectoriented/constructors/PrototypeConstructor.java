package com.objectoriented.constructors;

public class prototypeConstructor {

    public void p1(){
        System.out.println("p1 method is called");
    }
    //NOTE 
//1.Dafault constructor is always a no argument constructor 
//2.The access modifier of the default constructor is exactly same as the class access modifier(this rule is applicable only for public and default class) but for private and protected class the access modifier of the default constructor is public because if the access modifier of the default constructor is private or protected then we wont be able to create the object of the class and we wont be able to call the default constructor
//3.It contains only one line code which is "super()" and it is a no-arg call to super class constructor and it is used to call the default constructor of the super class
//4.Every no-arg constrcutor is a default constructor but every default constructor is not a no-arg constructor 
//5.We have to take super() or this() at the first line of the constructor else we may get compile time error.
//6.Within the constructor we can take either super() or this() but we cannot take them simultaneously.
//7.We have use this() or super() inside the constructor only not in method
// because if the class is private or protected then the access modifier of the default constructor is public and it is a no-arg constructor but if the class is public or default then the access modifier of the default constructor is same as the class access modifier and it is a no-arg constructor
//Compiler always check if the constructir is having super(); or this(); in the fisrt line of the constructor if it is not present then compiler will add super(); in the first line of the constructor and if the constructor is having super(); or this(); in the first line of the constructor.
 
public static void main(String[] args) {
        
        prototypeConstructor obj = new prototypeConstructor();
        System.out.println("Default constructor is called");
        //super();

    }
    
}
