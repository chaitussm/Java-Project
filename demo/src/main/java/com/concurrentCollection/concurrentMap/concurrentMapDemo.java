package com.concurrentCollection.concurrentMap;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class concurrentMapDemo {

    public static void concurrentCollectionType(String type) {
        switch (type) {
            case "ConcurrentHashMap":
                demonstrateConcurrentHashMap();
                break;
            case "ConcurrentSkipListMap":
                demonstrateConcurrentSkipListMap();
                break;
            case "ConcurrentMap":
                demonstrateConcurrentMap();
                break;
            default:
                System.out.println("Unknown concurrent map type");
                break;
        }
    }

    public static void concurrentConstructors(String type) {
        switch (type) {
            case "ConcurrentHashMap":
                demonstrateConcurrentHashMapConstructors();
                break;
            case "ConcurrentSkipListMap":
                demonstrateConcurrentSkipListMapConstructors();
                break;
            case "ConcurrentMap":
                demonstrateConcurrentMapConstructors();
                break;
            default:
                System.out.println("Unknown concurrent map type");
                break;
        }
    }

    public static void concurrentMapLoadFactor(String collectionType) {

        switch (collectionType) {
            case "ConcurrentHashMap":
            case "ConcurrentSkipListMap":
            case "ConcurrentMap":
                com.concurrentCollection.concurrentCollectionTypeInspector.printLoadFactorDetails(collectionType);
                break;
            default:
                throw new IllegalArgumentException("Load factor is not applicable to: " + collectionType);
        }
    }

    public static void demonstrateConcurrentHashMapConstructors() {
        System.out.println("Demonstrating constructors for ConcurrentHashMap:");

        // 1. Default Constructor
        ConcurrentHashMap<String, Integer> map1 = new ConcurrentHashMap<>();
        System.out.println(" -> Created empty ConcurrentHashMap (Default)");

        // 2. Initial Capacity Constructor
        ConcurrentHashMap<String, Integer> map2 = new ConcurrentHashMap<>(32);
        System.out.println(" -> Created with initial capacity: 32");

        // 3. Existing Map Constructor
        Map<String, Integer> traditionalMap = new HashMap<>();
        traditionalMap.put("Key1", 100);
        ConcurrentHashMap<String, Integer> map3 = new ConcurrentHashMap<>(traditionalMap);
        System.out.println(" -> Created from an existing Map instance");

        // 4. Initial Capacity and Load Factor Constructor
        ConcurrentHashMap<String, Integer> map4 = new ConcurrentHashMap<>(64, 0.75f);
        System.out.println(" -> Created with capacity: 64, load factor: 0.75");

        // 5. Initial Capacity, Load Factor, and Concurrency Level Constructor
        ConcurrentHashMap<String, Integer> map5 = new ConcurrentHashMap<>(128, 0.75f, 16);
        System.out.println(" -> Created with capacity: 128, load factor: 0.75, concurrency level: 16");

    }

    public static void demonstrateConcurrentSkipListMapConstructors() {
        System.out.println("Demonstrating constructors for ConcurrentSkipListMap:");

        // 1. Default Constructor (Orders keys according to their natural ordering)
        ConcurrentSkipListMap<String, Integer> skipMap1 = new ConcurrentSkipListMap<>();
        System.out.println(" -> Created empty ConcurrentSkipListMap (Natural Ordering)");

        // 2. Custom Comparator Constructor (Orders keys according to a custom
        // comparator)
        ConcurrentSkipListMap<String, Integer> skipMap2 = new ConcurrentSkipListMap<>((a, b) -> b.compareTo(a));
        System.out.println(" -> Created with a custom reverse-order Comparator");

        // 3. Existing Map Constructor
        Map<String, Integer> traditionalMap = new HashMap<>();
        traditionalMap.put("KeyA", 500);
        ConcurrentSkipListMap<String, Integer> skipMap3 = new ConcurrentSkipListMap<>(traditionalMap);
        System.out.println(" -> Created from an existing Map instance");

        // 4. SortedMap Constructor (Preserves the exact ordering of the source
        // SortedMap)
        ConcurrentSkipListMap<String, Integer> skipMap4 = new ConcurrentSkipListMap<>(skipMap2);
        System.out.println(" -> Created from an existing SortedMap instance");
        ;
    }

    public static void demonstrateConcurrentMapConstructors() {
        System.out.println("Demonstrating constructors for ConcurrentMap:");
        System.out.println("Note: ConcurrentMap is an interface, so it cannot be instantiated directly.");
        System.out.println("Instead, we instantiate its reference using implementing classes:");

        // Instantiating the interface using ConcurrentHashMap
        ConcurrentMap<String, Integer> concurrentMap1 = new ConcurrentHashMap<>();
        System.out.println(" -> ConcurrentMap reference assigned to a new ConcurrentHashMap instance");

        // Instantiating the interface using ConcurrentSkipListMap
        ConcurrentMap<String, Integer> concurrentMap2 = new ConcurrentSkipListMap<>();
        System.out.println(" -> ConcurrentMap reference assigned to a new ConcurrentSkipListMap instance");

    }

    public static void demonstrateConcurrentHashMap() {

        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.putIfAbsent("key1", "value1");
        map.put("key2", "value2");
        map.remove("key2");
        map.replace("key1", "newValue1");
        map.computeIfAbsent("key3", k -> "value3");
        map.entrySet().forEach(System.out::println);
        System.out.println("ConcurrentHashMap: " + map);
    }

    public static void demonstrateConcurrentSkipListMap() {

        ConcurrentSkipListMap<String, String> map = new ConcurrentSkipListMap<>();
        map.putIfAbsent("key1", "value1");
        map.put("key2", "value2");
        map.remove("key2");
        map.replace("key1", "newValue1");
        map.computeIfAbsent("key3", k -> "value3");
        map.entrySet().forEach(System.out::println);
        System.out.println("ConcurrentSkipListMap: " + map);
    }

    public static void demonstrateConcurrentMap() {

        ConcurrentMap<String, String> map = new ConcurrentHashMap<>();
        map.putIfAbsent("key1", "value1");
        map.put("key2", "value2");
        map.remove("key2");
        map.replace("key1", "newValue1");
        map.computeIfAbsent("key3", k -> "value3");
        map.entrySet().forEach(System.out::println);
        System.out.println("ConcurrentMap: " + map);
    }

}
