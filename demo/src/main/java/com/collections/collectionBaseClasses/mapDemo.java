package com.collections.collectionBaseClasses;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class mapDemo {

    // Dispatches to the requested Map implementation demo. Unknown/blank type falls back to HashMap.
    public static void mapCollectionType(String collectionType) {
        switch (collectionType) {
            case "LinkedHashMap":
                demonstrateLinkedHashMap();
                break;
            case "TreeMap":
                demonstrateTreeMap();
                break;
            case "Hashtable":
                demonstrateHashtable();
                break;
            case "HashMap":
            default:
                demonstrateHashMap();
                break;
        }
    }

    public static void mapConstructors(String collectionType) {
        switch (collectionType) {
            case "LinkedHashMap":
                demonstrateLinkedHashMapConstructors();
                break;
            case "TreeMap":
                demonstrateTreeMapConstructors();
                break;
            case "Hashtable":
                demonstrateHashtableConstructors();
                break;
            case "HashMap":
            default:
                demonstrateHashMapConstructors();
                break;
        }
    }

    public static void mapLoadFactor(String collectionType) {
        switch (collectionType) {
            case "HashMap":
            case "LinkedHashMap":
            case "Hashtable":
                CollectionTypeInspector.printLoadFactorDetails(collectionType);
                break;
            default:
                throw new IllegalArgumentException("Load factor is not applicable to: " + collectionType);
        }
    }

    private static void demonstrateHashMapConstructors() {
        Map<String, Integer> source = Map.of("A", 1, "B", 2);
        System.out.println("HashMap(): " + new HashMap<String, Integer>());
        System.out.println("HashMap(int): capacity 20 -> " + new HashMap<String, Integer>(20));
        System.out.println("HashMap(int, float): capacity 20, load factor 0.80 -> "
                + new HashMap<String, Integer>(20, 0.80f));
        System.out.println("HashMap(Map): " + new HashMap<>(source));
    }

    private static void demonstrateLinkedHashMapConstructors() {
        Map<String, Integer> source = Map.of("A", 1, "B", 2);
        System.out.println("LinkedHashMap(): " + new LinkedHashMap<String, Integer>());
        System.out.println("LinkedHashMap(int): capacity 20 -> " + new LinkedHashMap<String, Integer>(20));
        System.out.println("LinkedHashMap(int, float): capacity 20, load factor 0.80 -> "
                + new LinkedHashMap<String, Integer>(20, 0.80f));
        System.out.println("LinkedHashMap(int, float, boolean): access order -> "
                + new LinkedHashMap<String, Integer>(20, 0.80f, true));
        System.out.println("LinkedHashMap(Map): " + new LinkedHashMap<>(source));
    }

    private static void demonstrateTreeMapConstructors() {
        Map<String, Integer> source = Map.of("B", 2, "A", 1);
        Map<String, Integer> sortedSource = new TreeMap<>(source);
        System.out.println("TreeMap(): " + new TreeMap<String, Integer>());
        System.out.println("TreeMap(Comparator): "
                + new TreeMap<String, Integer>(Comparator.reverseOrder()));
        System.out.println("TreeMap(Map): " + new TreeMap<>(source));
        System.out.println("TreeMap(SortedMap): " + new TreeMap<>(sortedSource));
    }

    private static void demonstrateHashtableConstructors() {
        Map<String, Integer> source = Map.of("A", 1, "B", 2);
        System.out.println("Hashtable(): " + new Hashtable<String, Integer>());
        System.out.println("Hashtable(int): capacity 20 -> " + new Hashtable<String, Integer>(20));
        System.out.println("Hashtable(int, float): capacity 20, load factor 0.80 -> "
                + new Hashtable<String, Integer>(20, 0.80f));
        System.out.println("Hashtable(Map): " + new Hashtable<>(source));
    }

    // HashMap: hash-table backed. No insertion order guarantee; put/get/remove are average O(1). Allows one null key.
    private static void demonstrateHashMap() {
        System.out.println("===== HashMap =====");
        CollectionTypeInspector.printTypeInfo(HashMap.class, Map.class);
        CollectionTypeInspector.printDefaultInitialCapacity("HashMap");
        Map<String, Integer> map = new HashMap<>();

        // Basic methods
        map.put("Ram", 25);               // put(K,V) -> O(1) average, hashes key to a bucket
        map.put("Shyam", 30);
        map.put("Geeta", 28);
        map.put("Ram", 26);                // duplicate key -> overwrites value, does not add a new entry
        System.out.println("After put() (duplicate key \"Ram\" overwritten): " + map);

        System.out.println("get(\"Shyam\"): " + map.get("Shyam"));        // O(1) average
        System.out.println("containsKey(\"Geeta\"): " + map.containsKey("Geeta"));
        System.out.println("size(): " + map.size());

        map.remove("Geeta");               // O(1) average
        System.out.println("After remove(\"Geeta\"): " + map);

        // Cursor: Iterator over entrySet() - forward-only, can remove() while iterating; no ListIterator
        System.out.println("Iterator over entrySet() (order not guaranteed):");
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            System.out.println("  " + entry.getKey() + " = " + entry.getValue());
        }

        System.out.println("Core characteristic: no insertion-order guarantee; backed by a hash table,");
        System.out.println("so put/get/remove are fast (O(1) average) but iteration order is unpredictable.");
    }

    // LinkedHashMap: HashMap + a linked list running through entries. Preserves insertion order at a small cost.
    private static void demonstrateLinkedHashMap() {
        System.out.println("===== LinkedHashMap =====");
        CollectionTypeInspector.printTypeInfo(LinkedHashMap.class, Map.class);
        CollectionTypeInspector.printDefaultInitialCapacity("LinkedHashMap");
        Map<String, Integer> map = new LinkedHashMap<>();

        // Basic methods
        map.put("Ram", 25);                // put(K,V) -> O(1) average, also links into insertion-order chain
        map.put("Shyam", 30);
        map.put("Geeta", 28);
        System.out.println("After put(): " + map);

        System.out.println("get(\"Shyam\"): " + map.get("Shyam"));        // O(1) average
        map.remove("Shyam");               // O(1) average, also unlinks from the order chain
        System.out.println("After remove(\"Shyam\"): " + map);

        // Cursor: Iterator over entrySet() - forward-only, traverses in insertion order
        System.out.println("Iterator over entrySet() (insertion order preserved):");
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            System.out.println("  " + entry.getKey() + " = " + entry.getValue());
        }

        System.out.println("Core characteristic: insertion order IS preserved (unlike HashMap); backed by a hash table");
        System.out.println("plus a linked list, so it is slightly slower than HashMap but faster than TreeMap.");
    }

    // TreeMap: red-black tree backed. Keeps keys in sorted order; put/get/remove are O(log n). No null keys.
    private static void demonstrateTreeMap() {
        System.out.println("===== TreeMap =====");
        CollectionTypeInspector.printTypeInfo(TreeMap.class, Map.class);
        CollectionTypeInspector.printDefaultInitialCapacity("TreeMap");
        Map<String, Integer> map = new TreeMap<>();

        // Basic methods
        map.put("Ram", 25);                // put(K,V) -> O(log n), inserted at sorted key position
        map.put("Shyam", 30);
        map.put("Geeta", 28);
        System.out.println("After put() (stored in sorted key order): " + map);

        System.out.println("firstKey(): " + ((TreeMap<String, Integer>) map).firstKey()); // O(log n)
        System.out.println("lastKey(): " + ((TreeMap<String, Integer>) map).lastKey());   // O(log n)

        map.remove("Shyam");                // O(log n)
        System.out.println("After remove(\"Shyam\"): " + map);

        // Cursor: Iterator over entrySet() - forward-only, traverses in ascending key order
        System.out.println("Iterator over entrySet() (sorted key order):");
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            System.out.println("  " + entry.getKey() + " = " + entry.getValue());
        }

        System.out.println("Core characteristic: no insertion order; keys are always sorted (natural order or");
        System.out.println("a Comparator), so put/get/remove are O(log n), slower than HashMap's O(1) average.");
    }

    // Hashtable: legacy synchronized hash table. No insertion order; no null keys/values; slower than HashMap.
    private static void demonstrateHashtable() {
        System.out.println("===== Hashtable (legacy) =====");
        CollectionTypeInspector.printTypeInfo(Hashtable.class, Map.class);
        CollectionTypeInspector.printDefaultInitialCapacity("Hashtable");
        Map<String, Integer> map = new Hashtable<>();

        // Basic methods
        map.put("Ram", 25);                // synchronized put(K,V), O(1) average
        map.put("Shyam", 30);
        map.put("Geeta", 28);
        System.out.println("After put(): " + map);

        System.out.println("get(\"Shyam\"): " + map.get("Shyam"));        // synchronized, O(1) average
        map.remove("Geeta");                // synchronized, O(1) average
        System.out.println("After remove(\"Geeta\"): " + map);

        // Cursor 1: Iterator over entrySet() - forward-only, can remove() while iterating
        System.out.println("Iterator over entrySet() (order not guaranteed):");
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            System.out.println("  " + entry.getKey() + " = " + entry.getValue());
        }

        // Cursor 2: legacy Enumeration - forward-only, read-only, unique to Hashtable
        System.out.println("Enumeration traversal over keys (legacy):");
        java.util.Enumeration<String> enumeration = ((Hashtable<String, Integer>) map).keys();
        while (enumeration.hasMoreElements()) {
            System.out.println("  " + enumeration.nextElement());
        }

        System.out.println("Core characteristic: no insertion-order guarantee; every method is synchronized and");
        System.out.println("null keys/values are disallowed, making Hashtable slower than HashMap in single-threaded code.");
    }

}
