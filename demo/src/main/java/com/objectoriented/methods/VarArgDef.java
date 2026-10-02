package com.objectoriented.methods;

public class VarArg_def {

    //VAr arg methods are also called as variable length arguments methods or variable arguments methods or varargs methods.
    //Rules for var arg methods
    //1. Var arg methods are methods that can accept variable number of arguments of the same type.
    //2. Var arg methods are defined using the ellipsis (...) syntax in the method parameter list.
    //3. Var arg methods can have only one var arg parameter and it must be the last parameter in the method parameter list.
    //4. Var arg methods can be called with zero or more arguments of the specified type. If no arguments are passed, the var arg parameter will be treated as an empty array.
    //5. Var arg methods can also be called with an array of the specified type as an argument. In this case, the array will be passed directly to the var arg parameter.
    //6. Var arg methods can be overloaded with other methods that have different parameter lists, but they cannot be overloaded with another var arg method that has the same parameter type.
    //7. Var arg methods are useful when we want to create methods that can accept a variable number of arguments without having to overload the method for each possible number of arguments.
    //8. Var arg methods are stored in the stack memory and they are called as method level variables or block level variables of the class.
    
    public static void main(String[] args) {
        printNumbers(1, 2, 3); // calling var arg method with 3 arguments
        printNumbers(4, 5); // calling var arg method with 2 arguments
        printNumbers(); // calling var arg method with no arguments
        printNumbers(new int[]{6, 7, 8}); // calling var arg method with an array argument
    }

    public static void printNumbers(int... numbers) {
        System.out.println("Numbers: ");
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();
    }
    
}
