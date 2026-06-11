package com.objectoriented.instanceBlock;

import com.examples.Main;

public class instanceblockDef {

    // Instance block to demonstrate execution flow
    // 1. JVM checks for the instance members from top to bottom
    // 2. JVM checks for the any instance block defined in the class from top to bottom
    // 3. Constructor execution
    //Instance variables are initialized in the order they appear in the class.
   //Instance blocks are executed in the order they appear, during object creation.
   //If you try to access an instance variable in an instance block that comes before the variable’s declaration, it is not yet initialized, so you get an error.

    int i = 10;
    int j = 20;
    //first Instance block starts
    {
        firstMethodInInstanceBlock();
        
        System.out.println("First Instance block is executed : ");
    }
    
    //second Instance block starts
    {
        secondMethodInInstanceBlock();
        
        System.out.println("Second Instance block is executed : ");
    }
    
    //Here i and j values are first called from the fist and second instance blocks and their default values are stored as we can see they are intialized below the methods hence there default values are printed 
    //if we keep these values at above 10 and 20 values could have been printed 
    // int i = 10;
    // int j = 20;
    instanceblockDef()
    {
        System.out.println("Constructor");
    }
    public static void main(String[] args) {
        
        instanceblockDef idef = new instanceblockDef();
        
        System.out.println("Main Method");
    }
    
    
    public void firstMethodInInstanceBlock()
    {
        System.out.println(i);
    }
    
     
        //second instance block starts 
    public void secondMethodInInstanceBlock()
    {
        System.out.println(j);
    }
    
}
