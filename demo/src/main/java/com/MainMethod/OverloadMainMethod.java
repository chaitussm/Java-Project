package com.MainMethod;

public class OverloadMainMethod {

    //Overloading the main method 
    //Here JVM calls the main method with String[] args as the entry point of the program. 
    // However, we can overload the main method by defining additional main methods with different parameter lists
    // Bu the remaining methods needs to called separately as normal methods . These overloaded main methods can be called from the original main method or from other parts of the program.
    public static void main(String[] args) {
        System.out.println("This is the main method with String[] args");
        main(10);
        main("Hello");
    }

    public static void main(int num) {
        System.out.println("This is the overloaded main method with int parameter: " + num);
    }

    public static void main(String str) {
        System.out.println("This is the overloaded main method with String parameter: " + str);
    }
    
}
