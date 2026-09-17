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
                // Default initial capacity = 16 (power of two); grows by resizing the table
                // when threshold is exceeded.
                printCapacity(dataStructure, "16 buckets (default)",
                        "resize when size > capacity × load factor (default load factor 0.75)");
                break;
            case "ConcurrentSkipListMap":
                System.out.println("ConcurrentSkipListMap does not have a default initial capacity");
                break;
            case "ConcurrentMap":
                System.out.println("ConcurrentMap initial capacity depends on the underlying implementation");
                break;
            case "CopyOnWriteArrayList":
                System.out.println("CopyOnWriteArrayList initial capacity depends on the underlying array");
                break;
            case "CopyOnWriteArraySet":
                System.out.println("CopyOnWriteArraySet initial capacity depends on the underlying array");
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
                // Hash-based sets use a HashMap or LinkedHashMap table with default load factor
                // 0.75.
                printLoadFactor(collectionType, 16, 0.75f, "rehash when size reaches the threshold");

                break;
            case "ConcurrentSkipListMap":
                // Hash-based sets use a HashMap or LinkedHashMap table with default load factor
                // 0.75.
                printLoadFactor(collectionType, 16, 0.75f, "rehash when size reaches the threshold");

                break;
            case "ConcurrentMap":
                // Hash-based sets use a HashMap or LinkedHashMap table with default load factor
                // 0.75.
                printLoadFactor(collectionType, 16, 0.75f, "rehash when size reaches the threshold");
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
            case "copyonwritearraylist":
                return "CopyOnWriteArrayList";
            case "copyonwritearrayset":
                return "CopyOnWriteArraySet";
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
            case "CopyOnWriteArrayList":
                return java.util.concurrent.CopyOnWriteArrayList.class;
            case "CopyOnWriteArraySet":
                return java.util.concurrent.CopyOnWriteArraySet.class;
            default:
                throw new IllegalArgumentException("Unknown data structure: " + dataStructure);
        }
    }

    private static boolean usesLoadFactor(String dataStructure) {
        return dataStructure.equals("ConcurrentHashMap") || dataStructure.equals("ConcurrentMap");
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

    // Prints capacity, tuning, API, and behavior information for each requested
    // implementation.
    public static void printDefaultCapacitySummary(String... dataStructures) {
        if (dataStructures == null || dataStructures.length == 0) {
            throw new IllegalArgumentException("Provide at least one supported data structure.");
        }

        for (String dataStructure : dataStructures) {
            String supportedType = normalizeDataStructure(dataStructure);
            Class<?> structureClass = resolveDataStructureClass(supportedType);

            System.out.println("===== " + supportedType + " Details =====");
            printTypeInfo(structureClass);
            printDefaultInitialCapacity(supportedType);
            if (dataStructure.equals("ConcurrentHashMap")) {
                if (usesLoadFactor(supportedType)) {
                    printLoadFactorDetails(supportedType);
                }
            }
            printPublicMethods(structureClass);
            printBehaviorSummary(supportedType);
            System.out.println("====================================");
        }
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
            case "CopyOnWriteArrayList":
                System.out.println(
                        "  Thread-safe variant of ArrayList; all mutative operations are implemented by making a fresh copy of the underlying array.");
                break;

            case "CopyOnWriteArraySet":
                System.out.println(
                        "  Thread-safe variant of Set; all mutative operations are implemented by making a fresh copy of the underlying array.");
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
