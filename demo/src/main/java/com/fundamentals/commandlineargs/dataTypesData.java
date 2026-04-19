package com.fundamentals.commandlineargs;

import java.util.Scanner;

public class dataTypesData {

     // In this example we are providng the details from terminal using Scanner class and we are using the nextLine() method to read the input from the user and we are storing the input in a variable and then we are printing the input on the console.
    
    static Scanner scanner = new Scanner(System.in);


     public static void integerData()
     {
        
        System.out.println("Enter an integer: ");
      int number = scanner.nextInt();
      System.out.println("You entered: " + number);
      scanner.nextLine(); // consume newline
      }    

     public static void doubleData()
     {        
        System.out.println("Enter a double: ");
      double number = scanner.nextDouble();
      System.out.println("You entered: " + number);
      scanner.nextLine(); // consume newline
     }

     public static void stringData()
     {
        
        System.out.println("Enter a string: ");
        String str = scanner.nextLine();
        System.out.println("You entered: " + str);
        
     }

     public static void charData()
     {
        System.out.println("Enter a character: ");
      char ch = scanner.next().charAt(0);
      System.out.println("You entered: " + ch);
      scanner.nextLine(); // consume newline
     }

     public static void booleanData()
     {
        System.out.println("Enter a boolean value (true/false): ");
      boolean bool = scanner.nextBoolean();
      System.out.println("You entered: " + bool);
      scanner.nextLine(); // consume newline
     }

     public static void floatData()
     {
        System.out.println("Enter a float: ");
      float number = scanner.nextFloat();
      System.out.println("You entered: " + number);
      scanner.nextLine(); // consume newline
    }

     public static void longData()
     {
        System.out.println("Enter a long: ");
      long number = scanner.nextLong();
      System.out.println("You entered: " + number);
      scanner.nextLine(); // consume newline
     }

     public static void shortData()
     {
        System.out.println("Enter a short: ");
      short number = scanner.nextShort();
      System.out.println("You entered: " + number);
      scanner.nextLine(); // consume newline
     }


     public static void main(String[] args) {
        
        integerData();
        doubleData();
        stringData();
        charData();
        floatData();
        longData();
        shortData();
        booleanData();
        
     }

    
}
