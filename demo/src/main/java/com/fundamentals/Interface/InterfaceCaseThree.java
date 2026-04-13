package com.fundamentals.Interface;

interface primary
{
    int x = 7;
}

interface secondary
{
    int x = 10;
}
public class InterfaceCaseThree {

    //while implementing two interfaces if both the interfaces have same variable name then we have to use the interface name to access the variable because if we do not use the interface name to access the variable then it will give a compile time error because it will not know which variable to access when we call the variable from the object of the class.
    public static void main(String[] args) {
        System.out.println("Value of x from primary interface: " + primary.x);
        System.out.println("Value of x from secondary interface: " + secondary.x);
    }

    //variables inside the interface are public static and final by default. So, we can access the variable using the interface name without creating an instance of the class that implements the interface.
    //methods in interface are public and abstsract by default. So, we can access the method using the object of the class that implements the interface.
}
