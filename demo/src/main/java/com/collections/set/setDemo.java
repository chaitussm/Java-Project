package com.collections.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Comparator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import com.collections.collectionBaseClasses.CollectionTypeInspector;

public class setDemo {

    // Dispatches to the requested Set implementation demo. Unknown/blank type falls back to HashSet.
    public static void setCollectionType(String collectionType) {
        switch (collectionType) {
            case "LinkedHashSet":
                demonstrateLinkedHashSet();
                break;
            case "SortedSet":
                demonstrateSortedSet();
                break;
            case "NavigableSet":
                demonstrateNavigableSet();
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

    public static void setConstructors(String collectionType) {
        switch (collectionType) {
            case "LinkedHashSet":
                demonstrateLinkedHashSetConstructors();
                break;
            case "SortedSet":
            case "NavigableSet":
            case "TreeSet":
                demonstrateTreeSetConstructors();
                break;
            case "HashSet":
            default:
                demonstrateHashSetConstructors();
                break;
        }
    }

    public static void setLoadFactor(String collectionType) {
        switch (collectionType) {
            case "HashSet":
            case "LinkedHashSet":
                CollectionTypeInspector.printLoadFactorDetails(collectionType);
                break;
            default:
                throw new IllegalArgumentException("Load factor is not applicable to: " + collectionType);
        }
    }

    public static void setComparator(String collectionType) {
        switch (collectionType) {
            case "SortedSet":
            case "NavigableSet":
            case "TreeSet":
                demonstrateTreeSetComparator();
                break;
            default:
                throw new IllegalArgumentException("Comparator demonstration is only applicable to: " + collectionType);
        }
    }

    private static void demonstrateTreeSetComparator() {
        System.out.println("===== TreeSet Comparator =====");

        TreeSet<String> naturalOrder = new TreeSet<>();
        naturalOrder.add("Banana");
        naturalOrder.add("Apple");
        naturalOrder.add("Cherry");
        System.out.println("Natural ordering: " + naturalOrder);
        System.out.println("Natural comparator: " + naturalOrder.comparator());

        TreeSet<String> reverseOrder = new TreeSet<>(Comparator.reverseOrder());
        reverseOrder.addAll(naturalOrder);
        System.out.println("Reverse ordering: " + reverseOrder);
        System.out.println("Reverse comparator: " + reverseOrder.comparator());

        Comparator<String> byLengthThenName = Comparator.comparingInt(String::length)
                .thenComparing(Comparator.naturalOrder());
        TreeSet<String> lengthOrder = new TreeSet<>(byLengthThenName);
        lengthOrder.add("Java");
        lengthOrder.add("C");
        lengthOrder.add("Python");
        lengthOrder.add("Go");
        lengthOrder.add("Ruby");
        System.out.println("Length, then alphabetical ordering: " + lengthOrder);
        System.out.println("Custom comparator: " + lengthOrder.comparator());
        System.out.println("First element: " + lengthOrder.first());
        System.out.println("Last element: " + lengthOrder.last());
        System.out.println("Elements from length 1 through length 3: " + lengthOrder.subSet("C", "Java"));

        TreeSet<String> lengthOnly = new TreeSet<>(Comparator.comparingInt(String::length));
        lengthOnly.add("Java");
        boolean addedSameLength = lengthOnly.add("Ruby");
        System.out.println("Length-only TreeSet: " + lengthOnly);
        System.out.println("Was Ruby added? " + addedSameLength
                + " (false because compare(\"Java\", \"Ruby\") == 0)");

        System.out.println("Comparator flow: compare two values -> negative, zero, or positive");
        System.out.println("  negative: first value comes before second");
        System.out.println("  zero: values are treated as duplicates by TreeSet");
        System.out.println("  positive: first value comes after second");
        System.out.println("Use Comparator.naturalOrder() or null for natural ordering.");
    }

    private static void demonstrateHashSetConstructors() {
        Set<String> source = Set.of("A", "B");
        System.out.println("HashSet(): " + new HashSet<String>());
        System.out.println("HashSet(int): capacity 20 -> " + new HashSet<String>(20));
        System.out.println("HashSet(int, float): capacity 20, load factor 0.80 -> " + new HashSet<String>(20, 0.80f));
        System.out.println("HashSet(Collection): " + new HashSet<>(source));
    }

    private static void demonstrateLinkedHashSetConstructors() {
        Set<String> source = Set.of("A", "B");
        System.out.println("LinkedHashSet(): " + new LinkedHashSet<String>());
        System.out.println("LinkedHashSet(int): capacity 20 -> " + new LinkedHashSet<String>(20));
        System.out.println("LinkedHashSet(int, float): capacity 20, load factor 0.80 -> "
                + new LinkedHashSet<String>(20, 0.80f));
        System.out.println("LinkedHashSet(Collection): " + new LinkedHashSet<>(source));
    }

    private static void demonstrateTreeSetConstructors() {
        Set<String> source = Set.of("B", "A");
        Set<String> sortedSource = new TreeSet<>(source);
        System.out.println("TreeSet(): " + new TreeSet<String>());
        System.out.println("TreeSet(Comparator): " + new TreeSet<String>(Comparator.reverseOrder()));
        System.out.println("TreeSet(Collection): " + new TreeSet<>(source));
        System.out.println("TreeSet(SortedSet): " + new TreeSet<>(sortedSource));
    }

    // SortedSet is an interface. TreeSet provides its sorted-order implementation.
    private static void demonstrateSortedSet() {
        System.out.println("===== SortedSet (implemented by TreeSet) =====");
        CollectionTypeInspector.printTypeInfo(SortedSet.class, TreeSet.class);
        CollectionTypeInspector.printDefaultInitialCapacity("SortedSet");
        SortedSet<String> set = new TreeSet<>();
        set.add("Ram");
        set.add("Shyam");
        set.add("Geeta");
        set.add("Sita");

        System.out.println("Elements in natural sorted order: " + set);
        System.out.println("first(): " + set.first());
        System.out.println("last(): " + set.last());
        System.out.println("headSet(\"Ram\"): " + set.headSet("Ram"));
        System.out.println("tailSet(\"Ram\"): " + set.tailSet("Ram"));
        System.out.println("subSet(\"Geeta\", \"Shyam\"): " + set.subSet("Geeta", "Shyam"));
        System.out.println("comparator(): " + set.comparator() + " (null means natural ordering)");
        System.out.println("Core characteristic: SortedSet guarantees ascending element order and range views.");
    }

    // NavigableSet extends SortedSet. TreeSet adds nearest-match and descending-view operations.
    private static void demonstrateNavigableSet() {
        System.out.println("===== NavigableSet (implemented by TreeSet) =====");
        CollectionTypeInspector.printTypeInfo(NavigableSet.class, SortedSet.class, TreeSet.class);
        CollectionTypeInspector.printDefaultInitialCapacity("NavigableSet");
        NavigableSet<String> set = new TreeSet<>();
        set.add("Apple");
        set.add("Banana");
        set.add("Cherry");
        set.add("Mango");

        System.out.println("Elements in natural sorted order: " + set);
        System.out.println("lower(\"Cherry\"): " + set.lower("Cherry"));
        System.out.println("floor(\"Cherry\"): " + set.floor("Cherry"));
        System.out.println("ceiling(\"Coconut\"): " + set.ceiling("Coconut"));
        System.out.println("higher(\"Cherry\"): " + set.higher("Cherry"));
        System.out.println("descendingSet(): " + set.descendingSet());
        System.out.println("subSet(\"Banana\", true, \"Mango\", false): "
                + set.subSet("Banana", true, "Mango", false));
        System.out.println("Core characteristic: NavigableSet adds nearest-match searches and descending views.");
    }

    // HashSet: hash-table backed. No insertion order guarantee; add/contains/remove are average O(1).
    private static void demonstrateHashSet() {
        System.out.println("===== HashSet =====");
        CollectionTypeInspector.printTypeInfo(HashSet.class);
        CollectionTypeInspector.printDefaultInitialCapacity("HashSet");
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
        CollectionTypeInspector.printTypeInfo(LinkedHashSet.class);
        CollectionTypeInspector.printDefaultInitialCapacity("LinkedHashSet");
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
        CollectionTypeInspector.printTypeInfo(TreeSet.class);
        CollectionTypeInspector.printDefaultInitialCapacity("TreeSet");
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
