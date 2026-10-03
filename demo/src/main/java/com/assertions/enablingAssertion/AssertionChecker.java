package com.assertions.enablingAssertion;

public class AssertionChecker {

    public static void checkAge(int age) {
        /*Java throws an AssertionError with the message after :—including the actual age. If it’s true,
         execution continues; if assertions are disabled, the check is ignored.*/

        assert age >= 18 : "Access denied: age must be 18 or older. Provided: " + age;

        System.out.println("Access granted for age: " + age);
    }
}
