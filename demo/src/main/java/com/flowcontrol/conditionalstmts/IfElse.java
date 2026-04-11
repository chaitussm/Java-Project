package com.flowcontrol.conditionalstmts;

public class IfElse {

    //In If cluse only boolean expression is allowed and if the condition is true then the block of code inside the if statement will be executed otherwise it will be skipped.
    //In else cluse only boolean expression is allowed and if the condition is false then the block of code inside the else statement will be executed otherwise it will be skipped.
    // {} are not mandatory for if and else statements if there is only one statement inside the block, 
    //{} is mandatory only when there are multiple statements inside the block and initilize the variable inside the block, because if there is only one statement inside the block then it will be executed without the need of {} but if there are multiple statements inside the block then it will be executed only when the condition is true or false and it will be executed in the order they are written,
    // but it is a good practice to use them to avoid errors and improve readability.
    public static void main(String[] args) {
        int number = 10;

        if (number > 0) {
            System.out.println(number + " is a positive number.");
        } else if (number < 0) {
            System.out.println(number + " is a negative number.");
        } else {
            System.out.println(number + " is zero.");
        }

        // Important points to remember:
        // 1. The if-else statement allows you to execute different blocks of code based on the evaluation of a condition.
        // 2. The condition in the if statement must be a boolean expression that evaluates to true or false.
        // 3. You can have multiple else-if statements to check for multiple conditions, and an optional else statement to handle cases where none of the conditions are true.
    }
    
}
