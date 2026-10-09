package com.jvmArchitecture.howClassLoaderWorks;

/**
 * Classroom format — assume {@code Customer.class} is on extension and application class paths;
 * {@code Test.class} is on application classpath only.
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(String.class.getClassLoader());
        System.out.println(Test.class.getClassLoader());
        System.out.println(Customer.class.getClassLoader());
    }
}
