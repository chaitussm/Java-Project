package com.concurrentCollection.copyOnWriteArraySetClass;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

import com.concurrentCollection.concurrentCollectionTypeInspector;

public class copyOnWriteArrayListDemo {

    public static void concurrentCollectionType(String type) {

        demonstrateCopyOnWriteArraySet();
    }

    public static void concurrentConstructors(String type) {
        demonstrateCopyOnWriteArraySetConstructors();

    }

    public static void concurrentMapLoadFactor(String collectionType) {

        switch (collectionType) {
            case "CopyOnWriteArrayList":
                com.concurrentCollection.concurrentCollectionTypeInspector.printLoadFactorDetails(collectionType);
                break;
            default:
                throw new IllegalArgumentException("Load factor is not applicable to: " + collectionType);
        }
    }

    public static void demonstrateCopyOnWriteArraySetConstructors() {
        System.out.println("Demonstrating constructors for CopyOnWriteArraySet:");

        // 1. Default Empty Constructor
        // Creates an empty set. Internally, it initializes an empty
        // CopyOnWriteArrayList.
        CopyOnWriteArraySet<String> set1 = new CopyOnWriteArraySet<>();
        System.out.println(" -> Created an empty CopyOnWriteArraySet.");

        // 2. Collection Constructor
        // Creates a set containing the elements of the specified collection.
        // NOTE: Since it is a Set, duplicate items from the source collection are
        // automatically filtered out!
        Collection<String> inputCollection = new ArrayList<>();
        inputCollection.add("Arjun");
        inputCollection.add("Karna");
        inputCollection.add("Arjun"); // Duplicate element

        CopyOnWriteArraySet<String> set2 = new CopyOnWriteArraySet<>(inputCollection);
        System.out.println(" -> Created from an existing Collection.");
        System.out.println("    Initial set elements (Duplicates filtered out): " + set2);

    }

    public static void demonstrateCopyOnWriteArraySet() {

        concurrentCollectionTypeInspector.printDefaultCapacitySummary("CopyOnWriteArraySet");
        java.util.concurrent.CopyOnWriteArraySet<String> list = new java.util.concurrent.CopyOnWriteArraySet<>();
        list.add("value1");
        list.addAll(java.util.Arrays.asList("value2"));
        list.remove("value2");
        // list.set(0, "newValue1"); // Not applicable for CopyOnWriteArraySet
        list.add("value3");
        list.forEach(System.out::println);
        System.out.println("CopyOnWriteArraySet: " + list);
    }
}
