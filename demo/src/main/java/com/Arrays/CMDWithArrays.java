package com.Arrays;

public class CMDWithArrays {

    public static void main(String[] args) {
        

       String[] argh = {"x" , "y" , "z"};
        
        args = argh;
        
        for(String ar : args)
        {
            System.out.println("Data is : " + ar );
        }


        // Printing command-line arguments
        System.out.println("Command-line arguments:");
        for (int i = 0; i < args.length; i++) {
            System.out.println("Argument " + i + ": " + args[i]);
        }
    
    }
    
}
