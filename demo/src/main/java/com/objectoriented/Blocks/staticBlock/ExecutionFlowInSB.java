package com.objectoriented.Blocks.staticBlock;

public class executionFlowInSB {

    // Static block to demonstrate execution flow
    // 1. JVMN checks for the staticc memebrs from top to bottom
    // 2. JVM checks for the any static block defined in the class from top to bottom
    // 3. Main method execution
    //Static variables are initialized in the order they appear in the class.
   //Static blocks are executed in the order they appear, during class loading.
   //If you try to access a static variable in a static block that comes before the variable’s declaration, it is not yet initialized, so you get an error.

     static int y = 20;    
     static void methodA() {
        System.out.println("Static method in executionFlowInSB class.");
        //Note we have intialize the variable at the time of declaration inside the static block
        // If we dont intitalize we get below error
        //Main.java:10: error: variable might not have been initialized
        int x = 10;
        System.out.println("Hello I am from Static Block : " + x);
    }
    public static void main(String[] args) {
        System.out.println("This is Main method section");
    }
    
}
