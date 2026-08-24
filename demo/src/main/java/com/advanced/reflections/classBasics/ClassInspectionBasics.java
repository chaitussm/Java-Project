package com.advanced.reflections.classBasics;

public class ClassInspectionBasics {

    // A small class used as the reflection target.
    @SuppressWarnings("unused")
    private static class Student {
        private String name = "Asha";
    }

    public static void main(String[] args) throws ClassNotFoundException {
        // Obtain the Class object from an object instance.
        Student student = new Student();
        Class<?> fromObject = student.getClass();

        // Obtain the Class object directly from the class literal.
        Class<?> fromClassLiteral = Student.class;

        // Load a class by its fully qualified name at runtime.
        Class<?> fromName = Class.forName(
                "com.javaIOPackage.reflections.classBasics.ClassInspectionBasics$Student");

        // Print the class name known by the runtime.
        System.out.println("From object: " + fromObject.getName());
        System.out.println("From class literal: " + fromClassLiteral.getName());
        System.out.println("From class name: " + fromName.getName());

        // List fields declared directly by Student.
        System.out.println("Declared fields:");
        for (java.lang.reflect.Field field : fromClassLiteral.getDeclaredFields()) {
            System.out.println("  " + field.getName() + " : " + field.getType().getSimpleName());
        }
    }
}
