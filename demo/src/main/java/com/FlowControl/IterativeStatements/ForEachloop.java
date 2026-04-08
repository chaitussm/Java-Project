package com.FlowControl.IterativeStatements;

public class ForEachloop {
    
    //Understand the concept of for-each loop in Java
    //The for-each loop, also known as the enhanced for loop, is a control flow statement that allows you to iterate over elements in an array or a collection without needing to manage an index variable. 
    // It provides a simpler and more readable syntax for iterating through collections and arrays.
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};

        System.out.println("Using for-each loop:");
        for (int number : numbers) {
            System.out.println(number);
        }

        // Important points to remember:
        // 1. The for-each loop can only be used with arrays and classes that implement the Iterable interface (like ArrayList, HashSet, etc.).
        // 2. The syntax of the for-each loop is: for (type variable : collection) { // code to be executed }
        // 3. The variable declared in the for-each loop represents the current element in the iteration and is read-only; you cannot modify it within the loop.
        // 4. The for-each loop does not provide access to the index of the current element, so if you need to know the index, you should use a traditional for loop instead.
        // 5. limited to iterating through the collection in a forward direction; you cannot iterate backward or skip elements using a for-each loop.
    }
    
}
