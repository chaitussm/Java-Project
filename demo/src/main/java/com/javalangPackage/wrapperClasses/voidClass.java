package com.javalangPackage.wrapperClasses;

import java.lang.reflect.Method;

public class voidClass {

    /*
     * It is a final class and it is the direct child class of Object , It doesnt contains any methods and it contains 
     * only one variable Void.TYPE , in the reflections to check the method is void or not 
     */

  // Sample void method
    public void myVoidMethod() {
        System.out.println("Hello World");
    }

    // Sample non-void method
    public int myIntMethod() {
        return 42;
    }

    public static void main(String[] args) {
        try {
            Class<?> clazz = voidClass.class;
            
            // Check the void method
            Method method1 = clazz.getMethod("myVoidMethod");
            if (method1.getReturnType() == Void.TYPE) {
                System.out.println(method1.getName() + " has a void return type.");
            }

            // Check the int method
            Method method2 = clazz.getMethod("myIntMethod");
            if (method2.getReturnType() != Void.TYPE) {
                System.out.println(method2.getName() + " does NOT have a void return type.");
            }

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
    
}
