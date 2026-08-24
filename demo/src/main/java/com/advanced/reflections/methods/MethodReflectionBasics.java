package com.advanced.reflections.methods;

import java.lang.reflect.Method;

public class MethodReflectionBasics {

    // A class containing instance and private methods.
    @SuppressWarnings("unused")
    private static class Calculator {
        public int add(int first, int second) {
            return first + second;
        }

        private String message(String name) {
            return "Hello, " + name;
        }
    }

    public static void main(String[] args) throws Exception {
        // Create the object on which the reflected instance methods will run.
        Calculator calculator = new Calculator();

        // List methods declared directly by Calculator.
        for (Method method : Calculator.class.getDeclaredMethods()) {
            System.out.println("Method: " + method.getName());
        }

        // Find the public add method and provide its parameter types.
        Method addMethod = Calculator.class.getDeclaredMethod("add", int.class, int.class);

        // Invoke add dynamically: first argument is the target object,
        // followed by the method arguments.
        Object sum = addMethod.invoke(calculator, 7, 3);
        System.out.println("add result: " + sum);

        // Find the private message method.
        Method messageMethod = Calculator.class.getDeclaredMethod("message", String.class);

        // Allow reflection to invoke the private method.
        messageMethod.setAccessible(true);

        // Invoke the method and capture its returned value.
        Object message = messageMethod.invoke(calculator, "Asha");
        System.out.println("message result: " + message);
    }
}
