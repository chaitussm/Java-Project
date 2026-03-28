package com.VarArg_Methods;

public class VarArg_preference {

    //When both var arg method and non var arg method are present in the class then non var arg method will be preferred over var arg method when the method is called with the same number of arguments as the non var arg method.
    //This is because the non var arg method is more specific than the var arg method and it provides a better match for the method call.
    //If the method call does not match any of the non var arg methods, then the var arg method will be called if it matches the number of arguments passed in the method call.

    public static void main(String[] args) {
      printNumbers(1,2,3);
      printNumbers();

    }

    public static void printNumbers() {
        System.out.println("Non Var Arg Method: ");
    }

    public static void printNumbers(int... numbers) {
        System.out.println("Var Arg Method: ");
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();
    }
    
}
