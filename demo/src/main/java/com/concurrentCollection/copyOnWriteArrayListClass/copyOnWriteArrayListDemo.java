package com.concurrentCollection.copyOnWriteArrayListClass;

import java.util.HashMap;
import java.util.Map;

public class copyOnWriteArrayListDemo {

    public static void concurrentCollectionType(String type) {

        demonstrateCopyOnWriteArrayList();
    }

    public static void concurrentConstructors(String type) {
        demonstrateCopyOnWriteArrayListConstructors();

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

    public static void demonstrateCopyOnWriteArrayListConstructors() {
        System.out.println("Demonstrating constructors for CopyOnWriteArrayList:");

        // 1. Default Constructor (Capacity: 16, Fill Ratio/Load Factor: 0.75f,
        // Concurrency Level: 16)
        java.util.concurrent.CopyOnWriteArrayList<String> list1 = new java.util.concurrent.CopyOnWriteArrayList<>();
        System.out.println(" -> Created empty CopyOnWriteArrayList (Default settings)");

        // 2. Initial Capacity Constructor
        java.util.concurrent.CopyOnWriteArrayList<String> list2 = new java.util.concurrent.CopyOnWriteArrayList<>(
                java.util.Arrays.asList(new String[32]));
        System.out.println(" -> Created with initial capacity: 32");

        // 3. Existing Map Constructor
        Map<String, Integer> traditionalMap = new HashMap<>();
        traditionalMap.put("Key1", 100);
        java.util.concurrent.CopyOnWriteArrayList<String> list3 = new java.util.concurrent.CopyOnWriteArrayList<>(
                java.util.Arrays.asList("Key1"));
        System.out.println(" -> Created from an existing List instance");

        // 4. Custom Fill Ratio (Load Factor) Constructor
        // Capacity = 64, Fill Ratio = 0.50f (resizes when map becomes 50% full to
        // prevent hash collisions)
        float fillRatio = 0.50f;
        java.util.concurrent.CopyOnWriteArrayList<String> list4 = new java.util.concurrent.CopyOnWriteArrayList<>(
                java.util.Arrays.asList(new String[64]));
        System.out.println(" -> Created with capacity: 64");

        // 5. Full Tuning Constructor with Custom Fill Ratio and Concurrency Level
        // Capacity = 128, Fill Ratio = 0.75f, Concurrency Level = 32 (optimized for 32
        // threads writing concurrently)
        int initialCapacity = 128;
        float customFillRatio = 0.75f;
        int concurrencyLevel = 32;
        java.util.concurrent.CopyOnWriteArrayList<String> list5 = new java.util.concurrent.CopyOnWriteArrayList<>(
                java.util.Arrays.asList(new String[initialCapacity]));
        System.out.println(" -> Created with capacity: " + initialCapacity);

    }

    public static void demonstrateCopyOnWriteArrayList() {

        java.util.concurrent.CopyOnWriteArrayList<String> list = new java.util.concurrent.CopyOnWriteArrayList<>();
        list.addIfAbsent("value1");
        list.add("value2");
        list.remove("value2");
        list.set(0, "newValue1");
        list.addIfAbsent("value3");
        list.forEach(System.out::println);
        System.out.println("CopyOnWriteArrayList: " + list);
    }
}
