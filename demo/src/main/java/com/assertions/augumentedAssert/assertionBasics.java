package com.assertions.augumentedAssert;

public class assertionBasics {

    public static void main(String[] args) {
        // Enable assertions in code before AssertionChecker is first loaded.
        ClassLoader.getSystemClassLoader().setDefaultAssertionStatus(true);

        AssertionChecker.checkAge(25);

        try {
            AssertionChecker.checkAge(15);
        } catch (AssertionError error) {
            System.out.println("Caught expected assertion: " + error.getMessage());
        }
    }
}
