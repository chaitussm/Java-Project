package com.advanced.innerClass.example1;

public class basicMain {

     public static void main(String[] args) {
        // 1. Create an instance of the outer class
        OuterClass outer = new OuterClass();

        // 2. Use the outer instance to create an instance of the inner class
        OuterClass.InnerClasses inner = outer.new InnerClasses();

        // 3. Call the inner class method
        inner.display(); 
    }
    
}
