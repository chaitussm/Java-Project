package com.collections.collectionBaseClasses;

import java.lang.reflect.Modifier;
import java.lang.reflect.Method;
import java.util.Set;
import java.util.TreeSet;

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
            case "SortedSet":
            case "NavigableSet":
                // These are interfaces; TreeSet is their standard general-purpose implementation.
                printCapacity(dataStructure, "no fixed initial capacity", "TreeSet creates a red-black tree node for each element");
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

    // Prints capacity, tuning, API, and behavior information for each requested implementation.
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
            if (usesLoadFactor(supportedType)) {
                printLoadFactorDetails(supportedType);
            }
            printPublicMethods(structureClass);
            printBehaviorSummary(supportedType);
            System.out.println("====================================");
        }
    }

    private static String normalizeDataStructure(String dataStructure) {
        if (dataStructure == null || dataStructure.isBlank()) {
            throw new IllegalArgumentException("Data structure name cannot be blank.");
        }

        switch (dataStructure.trim().toLowerCase()) {
            case "arraylist":
                return "ArrayList";
            case "linkedlist":
                return "LinkedList";
            case "vector":
                return "Vector";
            case "stack":
                return "Stack";
            case "hashset":
                return "HashSet";
            case "linkedhashset":
                return "LinkedHashSet";
            case "treeset":
                return "TreeSet";
            case "sortedset":
                return "SortedSet";
            case "navigableset":
                return "NavigableSet";
            case "arraydeque":
                return "ArrayDeque";
            case "priorityqueue":
                return "PriorityQueue";
            case "hashmap":
                return "HashMap";
            case "linkedhashmap":
                return "LinkedHashMap";
            case "treemap":
                return "TreeMap";
            case "hashtable":
                return "Hashtable";
            default:
                throw new IllegalArgumentException("Unsupported data structure: " + dataStructure
                        + ". Supported types: ArrayList, LinkedList, Vector, Stack, HashSet, LinkedHashSet, "
                        + "TreeSet, SortedSet, NavigableSet, ArrayDeque, PriorityQueue, HashMap, LinkedHashMap, "
                        + "TreeMap, Hashtable.");
        }
    }

    private static Class<?> resolveDataStructureClass(String dataStructure) {
        switch (dataStructure) {
            case "ArrayList": return java.util.ArrayList.class;
            case "LinkedList": return java.util.LinkedList.class;
            case "Vector": return java.util.Vector.class;
            case "Stack": return java.util.Stack.class;
            case "HashSet": return java.util.HashSet.class;
            case "LinkedHashSet": return java.util.LinkedHashSet.class;
            case "TreeSet": return java.util.TreeSet.class;
            case "SortedSet": return java.util.SortedSet.class;
            case "NavigableSet": return java.util.NavigableSet.class;
            case "ArrayDeque": return java.util.ArrayDeque.class;
            case "PriorityQueue": return java.util.PriorityQueue.class;
            case "HashMap": return java.util.HashMap.class;
            case "LinkedHashMap": return java.util.LinkedHashMap.class;
            case "TreeMap": return java.util.TreeMap.class;
            case "Hashtable": return java.util.Hashtable.class;
            default: throw new IllegalArgumentException("Unsupported data structure: " + dataStructure);
        }
    }

    private static boolean usesLoadFactor(String dataStructure) {
        return dataStructure.equals("HashSet") || dataStructure.equals("LinkedHashSet")
                || dataStructure.equals("HashMap") || dataStructure.equals("LinkedHashMap")
                || dataStructure.equals("Hashtable");
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
            case "ArrayList": System.out.println("  Ordered, growable array; fast indexed access, slower middle insertions/removals."); break;
            case "LinkedList": System.out.println("  Doubly linked list and queue; fast end operations, slower indexed access."); break;
            case "Vector": System.out.println("  Legacy synchronized growable array; prefer ArrayList unless synchronization is required."); break;
            case "Stack": System.out.println("  Legacy LIFO stack; prefer ArrayDeque for new stack implementations."); break;
            case "HashSet": System.out.println("  Unique elements with no iteration order; add, contains, and remove are O(1) on average."); break;
            case "LinkedHashSet": System.out.println("  HashSet that preserves insertion order with a small memory and speed cost."); break;
            case "TreeSet": System.out.println("  Unique sorted elements; add, contains, and remove are O(log n)."); break;
            case "SortedSet": System.out.println("  Interface for sorted sets; TreeSet is the usual implementation and adds range views."); break;
            case "NavigableSet": System.out.println("  SortedSet interface with nearest-match and descending-view operations; TreeSet implements it."); break;
            case "ArrayDeque": System.out.println("  Resizable-array deque; efficient queue and stack operations at both ends."); break;
            case "PriorityQueue": System.out.println("  Heap-backed queue; head is the smallest element by natural order or Comparator."); break;
            case "HashMap": System.out.println("  Key-value lookup with no iteration order; put, get, and remove are O(1) on average."); break;
            case "LinkedHashMap": System.out.println("  HashMap that preserves insertion or access order."); break;
            case "TreeMap": System.out.println("  Keys stay sorted; put, get, and remove are O(log n)."); break;
            case "Hashtable": System.out.println("  Legacy synchronized map that does not allow null keys or values."); break;
            default: throw new IllegalArgumentException("Unsupported data structure: " + dataStructure);
        }
        System.out.println("-------------------");
    }

    public static void printLoadFactorDetails(String dataStructure) {
        System.out.println("----- Load Factor Details -----");
        switch (dataStructure) {
            case "HashSet":
            case "LinkedHashSet":
                // Hash-based sets use a HashMap or LinkedHashMap table with default load factor 0.75.
                printLoadFactor(dataStructure, 16, 0.75f, "rehash when size reaches the threshold");
                break;
            case "HashMap":
            case "LinkedHashMap":
                // Hash-based maps use a table with default load factor 0.75.
                printLoadFactor(dataStructure, 16, 0.75f, "rehash when size reaches the threshold");
                break;
            case "Hashtable":
                // Hashtable starts with 11 buckets and uses default load factor 0.75.
                printLoadFactor(dataStructure, 11, 0.75f, "rehash and grow using old capacity * 2 + 1");
                break;
            default:
                throw new IllegalArgumentException("Load factor is not applicable to: " + dataStructure);
        }
        System.out.println("--------------------------------");
    }

    private static void printLoadFactor(String dataStructure, int capacity, float loadFactor, String resizeRule) {
        int threshold = (int) (capacity * loadFactor);
        System.out.println("  " + dataStructure + ":");
        System.out.println("    capacity = " + capacity);
        System.out.println("    load factor = " + loadFactor);
        System.out.println("    threshold = capacity * load factor = " + capacity + " * " + loadFactor + " = " + threshold);
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
