package com.assertions.augumentedAssert;

public class AssertionChecker {

    public static void checkAge(int age) {
        // This assert checks the condition when assertions are enabled.
        // If it is false, Java throws an AssertionError with this detail message.
        assert age >= 18 : "Access denied: age must be 18 or older. Provided: " + age;

        System.out.println("Access granted for age: " + age);
    }
}
