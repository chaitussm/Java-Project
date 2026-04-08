package com.FlowControl.IterativeStatements;

public class Forloop {

    //Understand the concept of for loop in Java
    //The for loop is a control flow statement that allows code to be executed repeatedly based on a given boolean condition. 
    // The for loop consists of three parts: initialization, condition, and update. 
    // We can write print statement also in the initialization and update section of for loop but it is not a good practice to write print statement in the initialization and update section of for loop because it will make the code less readable and it will be difficult to understand the logic of the loop.
    // Initialization section executes one time at the beginning of the loop, condition is evaluated before each iteration, and update section executes after each iteration.
    // The initialization is executed once at the beginning of the loop, the condition is evaluated before each iteration, and the update is executed after each iteration.
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Count: " + i);
        }
        
        // int i =0;
        // for(System.out.println("Hello you are sleeping");i<3 ; System.out.println("soya bean"))
        // {
        //     System.out.println("Boss you are only sleeping");
        //     if(i==3)
        //     {
        //         System.out.println("Boss you are sleeping too much");
        //         break; // This will exit the loop when i is equal to 3, preventing an infinite loop.
        //     }
        // } infinite loop because the condition is always true and there is no update statement to change the value of i, so it will keep printing "Hello you are sleeping" and "Boss you are only sleeping" indefinitely, so the program will never reach the line to print "Boss you are sleeping too much" and it will never break the loop.


        // Important points to remember:
        // 1. The for loop is typically used when the number of iterations is known beforehand.
        // 2. The initialization part is executed only once at the beginning of the loop.
        // 3. The condition is evaluated before each iteration, and if it evaluates to false, the loop will terminate.
        // 4. The update part is executed after each iteration, allowing you to modify the loop variable or perform other operations.
        //5. In the conditonal section if we dont write anything JVM takes true by default and it will execute the loop indefinitely 
        // until we break the loop or we can write false in the conditional section then the loop will never execute because the condition is false from the beginning.
        // 6 insatead of increment and decrement operator we can write print statement in the update section but it is not a good practice to write print statement in the update section of for loop because it will make the code less readable and it will be difficult to understand the logic of the loop. 
    }
    
}
