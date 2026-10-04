package com.assertions.simpleAssert;

public class assertionBasics {

    public static void main(String[] args) {
        // Assertion status is fixed when a class is initialized, so enable it
        // before AssertionChecker is first loaded.
        ClassLoader.getSystemClassLoader().setDefaultAssertionStatus(true);

        System.out.println("--- Starting Assertion Test ---");

        AssertionChecker.checkAge(25);

        try {
            AssertionChecker.checkAge(15);
        } catch (AssertionError e) {
            System.out.println("Caught expected AssertionError for age below 18.");
        }

        System.out.println("\n--- Program finished execution safely ---");
    }
}
