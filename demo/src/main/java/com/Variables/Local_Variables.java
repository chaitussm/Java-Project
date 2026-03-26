package com.Variables;

public class Local_Variables {

    //classification of variables in java
    //1. Local variables
    //2. Instance variables
    //3. Static variables
    //4. primitive and object based  

    //rules for local variables
    //1. Local variables are declared inside a method, constructor or any block.
    //2. Local variables are created when the method, constructor or block is entered and destroyed
    //   when the method, constructor or block is exited.
    //3. Local variables can only be accessed within the method, constructor or block where they are declared.
    //4. Local variables must be initialized before they can be used. They do not have default values like instance and static variables.
    //5. Local variables are stored in the stack memory and they are called as method level variables or block level variables of the class.

    public static void main(String[] args) {
        int num1 = 10; // local variable
        int num2 = 20; // local variable
        int sum = num1 + num2; // local variable

        System.out.println("Sum = " + sum);
    }
    
}
