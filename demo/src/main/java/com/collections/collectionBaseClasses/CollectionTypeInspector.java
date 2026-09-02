package com.collections.collectionBaseClasses;

import java.lang.reflect.Modifier;

// Shared reflection-based helper: classifies each supplied type as INTERFACE, ABSTRACT CLASS, or CLASS.
public final class CollectionTypeInspector {

    private CollectionTypeInspector() {
    }

    // Prints a boxed classification table for the concrete implementation type and its collection interface(s).
    public static void printTypeInfo(Class<?>... types) {
        System.out.println("----- Type Classification -----");
        for (Class<?> type : types) {
            System.out.printf("  %-20s -> %s%n", type.getSimpleName(), classify(type));
        }
        System.out.println("--------------------------------");
    }

    // Prints the JDK-documented default initial capacity (and load factor, when applicable) for a no-arg constructor.
    public static void printDefaultInitialCapacity(String description) {
        System.out.println("----- Default Initial Capacity -----");
        System.out.println("  " + description);
        System.out.println("-------------------------------------");
    }

    private static String classify(Class<?> type) {
        if (type.isInterface()) {
            return "INTERFACE";
        }
        if (Modifier.isAbstract(type.getModifiers())) {
            return "ABSTRACT CLASS";
        }
        return "CLASS";
    }

}
