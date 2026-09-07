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

    // Selects the capacity rule for the requested collection implementation.
    public static void printDefaultInitialCapacity(String dataStructure) {
        System.out.println("----- Default Initial Capacity -----");
        switch (dataStructure) {
            case "ArrayList":
                // Initial capacity = 10; new capacity = old capacity + (old capacity / 2).
                printCapacity(dataStructure, "10 elements", "new capacity = old capacity + (old capacity / 2)");
                break;
            case "LinkedList":
                // LinkedList has no array capacity; each element is stored in a separate node.
                printCapacity(dataStructure, "no fixed initial capacity", "new node is created for each element");
                break;
            case "Vector":
                // Initial capacity = 10; new capacity = old capacity * 2 when capacityIncrement is zero.
                printCapacity(dataStructure, "10 elements", "new capacity = old capacity * 2");
                break;
            case "Stack":
                // Stack extends Vector, so it inherits Vector's capacity formula.
                printCapacity(dataStructure, "10 elements inherited from Vector", "new capacity = old capacity * 2");
                break;
            case "HashSet":
            case "LinkedHashSet":
                // Both set implementations use the same hash-table formula: resize threshold = 16 * 0.75 = 12.
                printCapacity(dataStructure, "16 buckets, load factor 0.75", "resize threshold = 16 * 0.75 = 12");
                break;
            case "TreeSet":
                // TreeSet has no array capacity; every element becomes a node in a red-black tree.
                printCapacity(dataStructure, "no fixed initial capacity", "a tree node is created for each element");
                break;
            case "ArrayDeque":
                // ArrayDeque uses a resizable circular array; capacity is maintained as a power of two.
                printCapacity(dataStructure, "16 elements", "capacity grows to the next required power of two");
                break;
            case "PriorityQueue":
                // For old capacity < 64: new capacity = old capacity + 2; otherwise new capacity = old capacity * 1.5.
                printCapacity(dataStructure, "11 elements", "if old capacity < 64: old capacity + 2; otherwise old capacity + (old capacity / 2)");
                break;
            case "HashMap":
            case "LinkedHashMap":
                // Both map implementations use the same hash-table formula: threshold = 16 * 0.75 = 12; capacity doubles.
                printCapacity(dataStructure, "16 buckets, load factor 0.75", "resize threshold = 16 * 0.75 = 12; new capacity = old capacity * 2");
                break;
            case "TreeMap":
                // TreeMap has no array capacity; every key-value pair becomes a red-black tree node.
                printCapacity(dataStructure, "no fixed initial capacity", "a tree node is created for each key-value pair");
                break;
            case "Hashtable":
                // Resize threshold = capacity * load factor = 11 * 0.75 = 8; new capacity = old capacity * 2 + 1.
                printCapacity(dataStructure, "11 buckets, load factor 0.75", "resize threshold = 11 * 0.75 = 8; new capacity = old capacity * 2 + 1");
                break;
            default:
                throw new IllegalArgumentException("Unsupported data structure: " + dataStructure);
        }
        System.out.println("-------------------------------------");
    }

    private static void printCapacity(String dataStructure, String initialCapacity, String formula) {
        System.out.println("  " + dataStructure + ": " + initialCapacity);
        System.out.println("  Formula: " + formula);
    }

    public static void printDefaultCapacitySummary() {
        System.out.println("===== Default Capacity Summary =====");
        System.out.println("List:");
        System.out.println("  ArrayList       -> 10 on first growth; new capacity is old capacity + half");
        System.out.println("  LinkedList      -> no array capacity; one node per element");
        System.out.println("  Vector          -> 10; doubles when full by default");
        System.out.println("  Stack           -> 10; inherits Vector capacity");
        System.out.println("Set:");
        System.out.println("  HashSet         -> 16 buckets, threshold = 16 * 0.75 = 12");
        System.out.println("  LinkedHashSet   -> 16 buckets, threshold = 16 * 0.75 = 12");
        System.out.println("  TreeSet         -> no array capacity; one tree node per element");
        System.out.println("Queue:");
        System.out.println("  LinkedList      -> no array capacity; one node per element");
        System.out.println("  ArrayDeque      -> default internal circular-array capacity");
        System.out.println("  PriorityQueue   -> 11; grows by old capacity + 2 below 64");
        System.out.println("Map:");
        System.out.println("  HashMap         -> 16 buckets, threshold = 16 * 0.75 = 12");
        System.out.println("  LinkedHashMap   -> 16 buckets, threshold = 16 * 0.75 = 12");
        System.out.println("  TreeMap         -> no array capacity; one tree node per entry");
        System.out.println("  Hashtable       -> 11 buckets, threshold = 11 * 0.75 = 8");
        System.out.println("====================================");
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
