package com.collections.arrays;

public class AssignmentOfObjInArrays {
    
    public static void assignObjectsInArray()
    {
       //rule 1 we can assign the object reference in arrays not the elements 
       //rule 2 the data type and dimension should be the same not the size of the array
       //rule 3 if we provide the full size of the data type sometimes the result may depends upon the heap memory available in the object initialized array

       int[] a = { 10,20,30};

       int[] b = {40,50};

       a = b;

       b = a; 

       ///by the above steop a is pointing towards b elements and b is pointing to a elements 
    }        
    
    public static void main(String[] args) {
        assignObjectsInArray();

        //we can prin the length of args array in mainmethod 

        System.out.println("Size of the arg array is : " + args.length);
    }
    
}
