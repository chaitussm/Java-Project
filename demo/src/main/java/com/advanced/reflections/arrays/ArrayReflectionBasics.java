package com.advanced.reflections.arrays;

import java.lang.reflect.Array;

public class ArrayReflectionBasics {

    public static void main(String[] args) {
        // Keep the array as Object so its exact component type is not required here.
        Object numbers = new int[] {10, 20, 30};

        // Ask reflection for the array length.
        int length = Array.getLength(numbers);
        System.out.println("Length: " + length);

        // Read every element through the generic reflection API.
        for (int index = 0; index < length; index++) {
            System.out.println("Element " + index + ": " + Array.get(numbers, index));
        }

        // Change an element without directly indexing the int array.
        Array.set(numbers, 1, 99);
        System.out.println("Changed element: " + Array.get(numbers, 1));

        // Create a new String array when the component type is known only at runtime.
        Object words = Array.newInstance(String.class, 2);
        Array.set(words, 0, "Java");
        Array.set(words, 1, "Reflection");
        System.out.println("Created array: " + Array.get(words, 0) + " " + Array.get(words, 1));
    }
}
