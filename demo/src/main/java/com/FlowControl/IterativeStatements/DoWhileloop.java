package com.FlowControl.IterativeStatements;

public class DoWhileloop {

    //Understand the concept of do-while loop in Java
    //if we want execute the body of do while loop at least once then we can use do while loop but if we want to execute the body of while loop at least once then we can use while loop.
    //The do-while loop is a control flow statement that allows code to be executed repeatedly based on a given boolean condition. 
    // The key difference between a do-while loop and a while loop is that the do-while loop guarantees that the code block will be executed at least once, 
    // because the condition is evaluated after the block of code is executed. 
    // If the condition is false at the beginning, the code inside the loop will still be executed once before the condition is checked.
    public static void main(String[] args) {
        int count = 1;

        do {
            System.out.println("Count: " + count);
            count++;
        } while (count <= 5);

        // Important points to remember:
        // 1. The do-while loop executes the block of code at least once, even if the condition is false initially.
        // 2. The condition is evaluated after the execution of the block of code, so it will continue to execute as long as the condition remains true.
        // 3. It is crucial to ensure that the condition eventually becomes false; otherwise, it can lead to an infinite loop.
        // 4. The variable used in the condition should be updated within the loop to avoid infinite loops and ensure proper termination.
    }
    
}
