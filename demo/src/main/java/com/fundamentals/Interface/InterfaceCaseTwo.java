package com.fundamentals.Interface;

interface NoArgument {
    void noarg();
}

interface Argument {
    void arg(int i);
}

public class InterfaceCaseTwo implements NoArgument, Argument {

    // If two interfaces have different method names, the implementing class must provide
    // concrete implementations for both methods.
    public void noarg() {
        System.out.println("No argument method implementation");
    }

    public void arg(int i) {
        System.out.println("Argument method implementation with value: " + i);
    }

    public static void main(String[] args) {
        InterfaceCaseTwo obj = new InterfaceCaseTwo();
        obj.noarg();
        obj.arg(10);
    }
    
}
