package com.concurrentCollection;

import java.lang.reflect.Modifier;

import java.lang.reflect.Method;
import java.util.Set;
import java.util.TreeSet;

public class concurrentCollectionTypeInspector {

    private concurrentCollectionTypeInspector() {
        // Private constructor to prevent instantiation
    }

    // Prints a boxed classification table for the concrete implementation type and
    // its collection interface(s).
    public static void printTypeInfo(Class<?>... types) {
        System.out.println("----- Type Classification -----");
        for (Class<?> type : types) {
            System.out.printf("  %-20s -> %s%n", type.getSimpleName(), classify(type));
        }
        System.out.println("--------------------------------");
    }

    /*
     * private static String classify(Class<?> type) {
     * if (java.util.concurrent.ConcurrentHashMap.class.isAssignableFrom(type)) {
     * return "ConcurrentHashMap";
     * } else if
     * (java.util.concurrent.ConcurrentSkipListMap.class.isAssignableFrom(type)) {
     * return "ConcurrentSkipListMap";
     * } else if (java.util.concurrent.ConcurrentMap.class.isAssignableFrom(type)) {
     * return "ConcurrentMap";
     * } else {
     * return "Unknown";
     * }
     * }
     */

    // Selects the capacity rule for the requested collection implementation.
    public static void printDefaultInitialCapacity(String dataStructure) {
        System.out.println("----- Default Initial Capacity -----");
        switch (dataStructure) {
            case "ConcurrentHashMap":
                // Initial capacity = 10; new capacity = old capacity + (old capacity / 2).
                printCapacity(dataStructure, "10 elements", "new capacity = old capacity + (old capacity / 2)");
                break;
            case "ConcurrentSkipListMap":
                System.out.println("ConcurrentSkipListMap does not have a default initial capacity");
                break;
            case "ConcurrentMap":
                System.out.println("ConcurrentMap initial capacity depends on the underlying implementation");
                break;
            default:
                throw new IllegalArgumentException("Initial capacity is not applicable to: " + dataStructure);
        }
        System.out.println("--------------------------------");
    }

    private static void printCapacity(String dataStructure, String initialCapacity, String formula) {
        System.out.println("  " + dataStructure + ": " + initialCapacity);
        System.out.println("  Formula: " + formula);
    }

    public static void printLoadFactorDetails(String collectionType) {
        switch (collectionType) {
            case "ConcurrentHashMap":
                System.out.println("ConcurrentHashMap has a default load factor of 0.75");
                break;
            case "ConcurrentSkipListMap":
                System.out.println("ConcurrentSkipListMap does not have a load factor");
                break;
            case "ConcurrentMap":
                System.out.println("ConcurrentMap load factor depends on the underlying implementation");
                break;
            default:
                throw new IllegalArgumentException("Load factor is not applicable to: " + collectionType);
        }
    }

    private static String normalizeDataStructure(String dataStructure) {
        if (dataStructure == null || dataStructure.isBlank()) {
            throw new IllegalArgumentException("Data structure name cannot be blank.");
        }

        switch (dataStructure.trim().toLowerCase()) {
            case "concurrenthashmap":
                return "ConcurrentHashMap";
            case "concurrentskiplistmap":
                return "ConcurrentSkipListMap";
            case "concurrentmap":
                return "ConcurrentMap";
            default:
                throw new IllegalArgumentException("Unknown data structure: " + dataStructure);
        }
    }

    private static Class<?> resolveDataStructureClass(String dataStructure) {
        switch (dataStructure) {
            case "ConcurrentHashMap":
                return java.util.concurrent.ConcurrentHashMap.class;
            case "ConcurrentSkipListMap":
                return java.util.concurrent.ConcurrentSkipListMap.class;
            case "ConcurrentMap":
                return java.util.concurrent.ConcurrentMap.class;
            default:
                throw new IllegalArgumentException("Unknown data structure: " + dataStructure);
        }
    }

    private static boolean usesLoadFactor(String dataStructure) {
        return dataStructure.equals("ConcurrentHashMap") || dataStructure.equals("ConcurrentSkipListMap")
                || dataStructure.equals("ConcurrentMap");
    }

    private static void printPublicMethods(Class<?> structureClass) {
        Set<String> methodNames = new TreeSet<>();
        for (Method method : structureClass.getMethods()) {
            if (method.getDeclaringClass() != Object.class) {
                methodNames.add(method.getName());
            }
        }

        System.out.println("----- Public Methods -----");
        StringBuilder line = new StringBuilder("  ");
        int methodsOnLine = 0;
        for (String methodName : methodNames) {
            if (methodsOnLine == 5) {
                System.out.println(line);
                line.setLength(0);
                line.append("  ");
                methodsOnLine = 0;
            }
            if (methodsOnLine > 0) {
                line.append(", ");
            }
            line.append(methodName).append("()");
            methodsOnLine++;
        }
        if (methodsOnLine > 0) {
            System.out.println(line);
        }
        System.out.println("--------------------------");
    }

    private static void printBehaviorSummary(String dataStructure) {
        System.out.println("----- Summary -----");
        switch (dataStructure) {
            case "ConcurrentHashMap":
                System.out.println("  Thread-safe hash map with high concurrency; does not allow null keys or values.");
                break;
            case "ConcurrentSkipListMap":
                System.out.println("  Thread-safe sorted map; supports concurrent access and maintains key order.");
                break;
            case "ConcurrentMap":
                System.out.println("  Interface for thread-safe maps; ConcurrentHashMap is a common implementation.");
                break;
            default:
                throw new IllegalArgumentException("Unsupported data structure: " + dataStructure);
        }
        System.out.println("-------------------");
    }

    private static void printLoadFactor(String dataStructure, int capacity, float loadFactor, String resizeRule) {
        int threshold = (int) (capacity * loadFactor);
        System.out.println("  " + dataStructure + ":");
        System.out.println("    capacity = " + capacity);
        System.out.println("    load factor = " + loadFactor);
        System.out.println(
                "    threshold = capacity * load factor = " + capacity + " * " + loadFactor + " = " + threshold);
        System.out.println("    rule: " + resizeRule);
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
