package com.collections.collectionBaseClasses;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class setDemo {

    // Dispatches to the requested Set implementation demo. Unknown/blank type falls back to HashSet.
    public static void setCollectionType(String collectionType) {
        switch (collectionType) {
            case "LinkedHashSet":
                demonstrateLinkedHashSet();
                break;
            case "TreeSet":
                demonstrateTreeSet();
                break;
            case "HashSet":
            default:
                demonstrateHashSet();
                break;
        }
    }

    // HashSet: hash-table backed. No insertion order guarantee; add/contains/remove are average O(1).
    private static void demonstrateHashSet() {
        System.out.println("===== HashSet =====");
        CollectionTypeInspector.printTypeInfo(HashSet.class, Set.class);
        CollectionTypeInspector.printDefaultInitialCapacity("HashSet: 16 buckets, load factor 0.75 (backed by a HashMap)");
        Set<String> set = new HashSet<>();

        // Basic methods
        set.add("Ram");                  // add(E) -> O(1) average, hashes the element to a bucket
        set.add("Shyam");
        set.add("Geeta");
        set.add("Ram");                   // duplicate -> ignored, add() returns false
        System.out.println("After add() (duplicate \"Ram\" ignored): " + set);

        System.out.println("contains(\"Shyam\"): " + set.contains("Shyam")); // O(1) average
        System.out.println("size(): " + set.size());

        set.remove("Geeta");              // O(1) average
        System.out.println("After remove(\"Geeta\"): " + set);

        // Cursor: Iterator - forward-only, can remove() while iterating; no ListIterator (no index concept)
        System.out.println("Iterator traversal (order not guaranteed):");
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println("  " + iterator.next());
        }

        System.out.println("Core characteristic: no insertion-order guarantee; backed by a hash table,");
        System.out.println("so add/contains/remove are fast (O(1) average) but iteration order is unpredictable.");
    }

    // LinkedHashSet: HashSet + a linked list running through entries. Preserves insertion order at a small cost.
    private static void demonstrateLinkedHashSet() {
        System.out.println("===== LinkedHashSet =====");
        CollectionTypeInspector.printTypeInfo(LinkedHashSet.class, Set.class);
        CollectionTypeInspector.printDefaultInitialCapacity("LinkedHashSet: 16 buckets, load factor 0.75 (backed by a LinkedHashMap)");
        Set<String> set = new LinkedHashSet<>();

        // Basic methods
        set.add("Ram");                  // add(E) -> O(1) average, also links into insertion-order chain
        set.add("Shyam");
        set.add("Geeta");
        System.out.println("After add(): " + set);

        System.out.println("contains(\"Shyam\"): " + set.contains("Shyam")); // O(1) average
        set.remove("Shyam");              // O(1) average, also unlinks from the order chain
        System.out.println("After remove(\"Shyam\"): " + set);

        // Cursor: Iterator - forward-only, traverses in insertion order
        System.out.println("Iterator traversal (insertion order preserved):");
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println("  " + iterator.next());
        }

        System.out.println("Core characteristic: insertion order IS preserved (unlike HashSet); backed by a hash table");
        System.out.println("plus a linked list, so it is slightly slower than HashSet but faster than TreeSet.");
    }

    // TreeSet: red-black tree backed. Keeps elements in sorted order; operations are O(log n).
    private static void demonstrateTreeSet() {
        System.out.println("===== TreeSet =====");
        CollectionTypeInspector.printTypeInfo(TreeSet.class, Set.class);
        CollectionTypeInspector.printDefaultInitialCapacity("TreeSet: no capacity concept (backed by a TreeMap red-black tree)");
        Set<String> set = new TreeSet<>();

        // Basic methods
        set.add("Ram");                  // add(E) -> O(log n), inserted into sorted tree position
        set.add("Shyam");
        set.add("Geeta");
        System.out.println("After add() (stored in sorted order): " + set);

        System.out.println("contains(\"Shyam\"): " + set.contains("Shyam")); // O(log n)
        System.out.println("first(): " + ((TreeSet<String>) set).first());  // O(log n)
        System.out.println("last(): " + ((TreeSet<String>) set).last());    // O(log n)

        set.remove("Shyam");              // O(log n)
        System.out.println("After remove(\"Shyam\"): " + set);

        // Cursor: Iterator - forward-only, traverses in ascending sorted order
        System.out.println("Iterator traversal (sorted order):");
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println("  " + iterator.next());
        }

        System.out.println("Core characteristic: no insertion order; elements are always sorted (natural order or");
        System.out.println("a Comparator), so add/contains/remove are O(log n), slower than HashSet's O(1) average.");
    }

}
