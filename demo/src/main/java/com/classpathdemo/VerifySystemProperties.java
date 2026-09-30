package com.classpathdemo;

/** Behavior changes with {@code java -Dcourse=scjp ...}. */
public class VerifySystemProperties {

    public static void main(String[] args) {
        String course = System.getProperty("course");
        if (course != null && course.equals("scjp")) {
            System.out.println("scjp information");
        } else {
            System.out.println("non-scjp information");
        }
    }
}
