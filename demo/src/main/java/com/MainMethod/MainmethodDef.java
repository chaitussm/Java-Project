package com.MainMethod;

public class MainmethodDef {
    //explanation of maina method 
    //1. The main method is the entry point of a Java application. It is where the program starts executing.
    //2. The main method must be declared as public, static, and void. This
    //3.public : Its helps to locvate the main method from anywhere by the JVM to call 
    //4.static : It helps to call the main method without creating an object of the class. The main method is called by the JVM before any objects are created, so it must be static.
    //5. void : It indicates that the main method does not return any value. The
    //6. The main method takes a single parameter, which is an array of Strings (String[] args). This parameter allows the program to accept command-line arguments when it is executed.
    //7.the strning[] args are command line arguments which are passed to the main method when the program is executed. 
    // These arguments can be used to provide input to the program or to specify certain options or configurations.
    
    public static void main(String[] args) {
        System.out.println("This is the main method definition");
    }

    //Main method can be called different ways 

    //1. to change the sequence of the format
    /*static public void main(String[] args) {
        System.out.println("This is the main method definition with + "static public format");
    }
    
    //2.changing the string[] args as command line arguments 
    public static void main(String[] ...args) {
        System.out.println("This is the main method definition with + "commandLineArgs format");
    }
    //3.Adding different keywords before the main methoid 
    final synchronized strictfp public static void main(String[] args) {
        System.out.println("This is the main method definition with + "final synchronized format");
    }*/

}
