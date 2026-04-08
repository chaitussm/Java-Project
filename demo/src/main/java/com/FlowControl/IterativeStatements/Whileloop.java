package com.FlowControl.IterativeStatements;

public class Whileloop {

    //Understand the concept of while loop in Java
    //The while loop is a control flow statement that allows code to be executed repeatedly based on a given boolean condition. 
    // The loop will continue to execute as long as the condition evaluates to true. 
    // If the condition is false at the beginning, the code inside the loop will not be executed at all.
    //if we dont know the number of iterations then we can use while loop but if we know the number of iterations then we can use for loop.
    // like if else {} are not mandatory for if and else statements if there is only one statement inside the block, 
    // {} is mandatory only when there are multiple statements inside the block and initilize the variable inside the block, because if there is only one statement inside the block then it will be executed
    public static void main(String[] args) {
        int count = 1;

        while (count <= 5) {
            System.out.println("Count: " + count);
            count++;
        }
        
        while (true) {
            System.out.println("This is an infinite loop.");
            // To avoid an infinite loop, you can include a break statement or ensure that the condition eventually becomes false.
            break; // This will exit the loop after the first iteration.
        }

        // while (true) {
        //     System.out.println("Hello");
                    
        // }
        //System.out.println("Hi"); // This line will never be reached because the while loop above is an infinite loop and it will keep printing "Hello" indefinitely, so the program will never reach this line to print "Hi".
        // Important points to remember:
        // 1. The while loop checks the condition before executing the block of code, so if the condition is false initially, the code inside the loop will not execute.
        // 2. It is crucial to ensure that the condition eventually becomes false; otherwise, it can lead to an infinite loop.
        // 3. The variable used in the condition should be updated within the loop to avoid infinite loops and ensure proper termination.
        // 4. inside while arguments its always boolean expression is allowed and if the condition is true then the block of code inside the while loop will be executed otherwise it will be skipped.
    }
    
}
