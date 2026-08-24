package com.javalangPackage.reflections.complete;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class CompleteReflectionExample {

    // This target class gives the example a constructor, field, and method to inspect.
    @SuppressWarnings("unused")
    private static class Employee {
        private String name;

        private Employee(String name) {
            this.name = name;
        }

        private String introduce() {
            return "Employee: " + name;
        }
    }

    public static void main(String[] args) throws Exception {
        // Obtain runtime metadata for the Employee class.
        Class<Employee> employeeClass = Employee.class;

        // Find and invoke the private constructor.
        Constructor<Employee> constructor = employeeClass.getDeclaredConstructor(String.class);
        constructor.setAccessible(true);
        Employee employee = constructor.newInstance("Neha");

        // Find the private name field and read its actual value.
        Field nameField = employeeClass.getDeclaredField("name");
        nameField.setAccessible(true);
        System.out.println("Field value: " + nameField.get(employee));

        // Find and invoke the private introduce method.
        Method introduceMethod = employeeClass.getDeclaredMethod("introduce");
        introduceMethod.setAccessible(true);
        System.out.println("Method result: " + introduceMethod.invoke(employee));

        // Print the class and method modifiers as readable text.
        System.out.println("Class modifiers: " + Modifier.toString(employeeClass.getModifiers()));
        System.out.println("Method modifiers: " + Modifier.toString(introduceMethod.getModifiers()));
    }
}
