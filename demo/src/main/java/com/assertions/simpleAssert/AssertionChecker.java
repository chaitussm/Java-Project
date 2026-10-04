package com.assertions.simpleAssert;

public class AssertionChecker {

    public static void checkAge(int age) {
        // A simple assert checks only the condition and does not provide a detail message.
        assert age >= 18;

        System.out.println("Access granted for age: " + age);
    }
}
