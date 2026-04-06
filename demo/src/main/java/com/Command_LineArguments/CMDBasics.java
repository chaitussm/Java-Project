package com.Command_LineArguments;

public class CMDBasics {

    //Common line arguments are required to change the behaviour of the main method at runtime. 
    // It is a way to pass information to the program when it is executed. The main method in Java takes an array of strings as an argument, 
    // which can be used to pass command line arguments to the program.

    public static void simpleData(String[] args)
    {
          // Simulate command line arguments for demonstration
          args = new String[]{"A", "B", "C"};
        
        // Check if any command line arguments are provided
        if (args.length > 0) {
            System.out.println("Command line arguments:");
            for (String arg : args) {
                System.out.println(arg);
            }
        } else {
            System.out.println("No command line arguments provided.");
        }
    }

    public static void AddData(String[] args)
    {
        // Simulate command line arguments for demonstration
        args = new String[]{"5", "10"};
        
        // Check if any command line arguments are provided
        if (args.length > 0) {
            int sum = 0;
            for (String arg : args) {
                sum += Integer.parseInt(arg);
            }
            System.out.println("Sum of command line arguments: " + sum);
        } else {
            System.out.println("No command line arguments provided.");
        }
    }

    public static void stringData(String[] args)
    {
        // Simulate command line arguments for demonstration
        args = new String[]{"Hello", "World"};
        
        // Check if any command line arguments are provided
        if (args.length > 0) {
            StringBuilder result = new StringBuilder();
            for (String arg : args) {
                result.append(arg).append(" ");
            }
            System.out.println("Concatenated command line arguments: " + result.toString().trim());
        } else {
            System.out.println("No command line arguments provided.");
        }
    }
    public static void main(String[] args) {

        simpleData(args);//For simple arguments
        AddData(args);//For addition arguments
        stringData(args);//For string arguments

    }
    
}
