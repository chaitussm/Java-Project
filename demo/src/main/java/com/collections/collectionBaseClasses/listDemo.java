package com.collections.collectionBaseClasses;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;
import java.util.Vector;

public class listDemo {

    // Dispatches to the requested List implementation demo. Unknown/blank type falls back to ArrayList.
    public static void listCollectionType(String collectionType) {
        switch (collectionType) {
            case "LinkedList":
                demonstrateLinkedList();
                break;
            case "Vector":
                demonstrateVector();
                break;
            case "Stack":
                demonstrateStack();
                break;
            case "ArrayList":
            default:
                demonstrateArrayList();
                break;
        }
    }

    // ArrayList: resizable array. Fast random access (get/set are O(1)); slow mid-list insert/remove (O(n) shift).
    private static void demonstrateArrayList() {
        System.out.println("===== ArrayList =====");
        CollectionTypeInspector.printTypeInfo(ArrayList.class, List.class);
        CollectionTypeInspector.printDefaultInitialCapacity("ArrayList: 10 elements (new Object[10] backing array)");
        List<String> list = new ArrayList<>();

        // Basic methods
        list.add("Ram");                 // add(E) -> append at end, O(1) amortized
        list.add("Shyam");
        list.add("Geeta");
        list.add(1, "Sita");             // add(index, E) -> shifts elements right, O(n)
        System.out.println("After add(): " + list);

        System.out.println("get(0): " + list.get(0));            // O(1) - direct array index access
        list.set(2, "Shyam-Updated");    // set(index, E) -> O(1)
        System.out.println("After set(2, ...): " + list);

        System.out.println("indexOf(\"Geeta\"): " + list.indexOf("Geeta"));
        System.out.println("contains(\"Sita\"): " + list.contains("Sita"));
        System.out.println("size(): " + list.size());

        list.remove("Sita");             // remove(Object) -> linear search then shift, O(n)
        System.out.println("After remove(\"Sita\"): " + list);

        // Cursor 1: Iterator - forward-only, can remove() while iterating
        System.out.println("Iterator traversal:");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println("  " + iterator.next());
        }

        // Cursor 2: ListIterator - bidirectional, can add()/set()/remove() while iterating
        System.out.println("ListIterator traversal (forward then backward):");
        ListIterator<String> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            System.out.println("  forward -> " + listIterator.next());
        }
        while (listIterator.hasPrevious()) {
            System.out.println("  backward -> " + listIterator.previous());
        }

        System.out.println("Core characteristic: insertion order is preserved; backed by a growable array,");
        System.out.println("so get/set are fast (O(1)) but insert/remove in the middle are slow (O(n)) due to shifting.");
    }

    // LinkedList: doubly-linked list. Fast add/remove at ends (O(1)); slow random access get(index) (O(n) traversal).
    private static void demonstrateLinkedList() {
        System.out.println("===== LinkedList =====");
        CollectionTypeInspector.printTypeInfo(LinkedList.class, List.class);
        CollectionTypeInspector.printDefaultInitialCapacity("LinkedList: no capacity concept (node-based; grows/shrinks one node at a time)");
        LinkedList<String> list = new LinkedList<>();

        // Basic methods
        list.add("Ram");                 // add(E) -> append at end, O(1)
        list.add("Shyam");
        list.addFirst("Geeta");          // Deque method -> insert at head, O(1)
        list.addLast("Sita");            // Deque method -> insert at tail, O(1)
        System.out.println("After add()/addFirst()/addLast(): " + list);

        System.out.println("getFirst(): " + list.getFirst());   // O(1) - direct head reference
        System.out.println("getLast(): " + list.getLast());     // O(1) - direct tail reference
        System.out.println("get(2): " + list.get(2));           // O(n) - must walk the links

        list.removeFirst();              // O(1) - unlink head node
        list.removeLast();               // O(1) - unlink tail node
        System.out.println("After removeFirst()/removeLast(): " + list);

        // Cursor 1: Iterator - forward-only, can remove() while iterating
        System.out.println("Iterator traversal:");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println("  " + iterator.next());
        }

        // Cursor 2: ListIterator - bidirectional, can add()/set()/remove() while iterating
        System.out.println("ListIterator traversal (forward then backward):");
        ListIterator<String> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            System.out.println("  forward -> " + listIterator.next());
        }
        while (listIterator.hasPrevious()) {
            System.out.println("  backward -> " + listIterator.previous());
        }

        System.out.println("Core characteristic: insertion order is preserved; backed by linked nodes,");
        System.out.println("so add/remove at either end are fast (O(1)) but get(index) is slow (O(n)),");
        System.out.println("unlike ArrayList where get(index) is fast (O(1)).");
    }

    // Vector: legacy synchronized resizable array. Same growth model as ArrayList but every method is synchronized.
    private static void demonstrateVector() {
        System.out.println("===== Vector (legacy) =====");
        CollectionTypeInspector.printTypeInfo(Vector.class, List.class);
        CollectionTypeInspector.printDefaultInitialCapacity("Vector: 10 elements (doubles its size when full, unlike ArrayList's 1.5x growth)");
        Vector<String> list = new Vector<>();

        // Basic methods
        list.add("Ram");                 // synchronized add(E), O(1) amortized
        list.add("Shyam");
        list.add("Geeta");
        list.add(1, "Sita");             // synchronized add(index, E), O(n)
        System.out.println("After add(): " + list);

        System.out.println("get(0): " + list.get(0));            // synchronized, O(1)
        list.set(2, "Shyam-Updated");    // synchronized set(index, E), O(1)
        System.out.println("After set(2, ...): " + list);

        list.remove("Sita");             // synchronized remove(Object), O(n)
        System.out.println("After remove(\"Sita\"): " + list);

        // Cursor 1: Iterator - forward-only, can remove() while iterating
        System.out.println("Iterator traversal:");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println("  " + iterator.next());
        }

        // Cursor 2: ListIterator - bidirectional cursor
        System.out.println("ListIterator traversal (forward then backward):");
        ListIterator<String> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            System.out.println("  forward -> " + listIterator.next());
        }
        while (listIterator.hasPrevious()) {
            System.out.println("  backward -> " + listIterator.previous());
        }

        // Cursor 3: legacy Enumeration - forward-only, read-only, unique to Vector
        System.out.println("Enumeration traversal (legacy):");
        java.util.Enumeration<String> enumeration = list.elements();
        while (enumeration.hasMoreElements()) {
            System.out.println("  " + enumeration.nextElement());
        }

        System.out.println("Core characteristic: insertion order is preserved; identical growth strategy to ArrayList,");
        System.out.println("but every method is synchronized, making Vector slower than ArrayList in single-threaded code.");
    }

    // Stack: legacy LIFO structure that extends Vector. Same synchronization cost, plus push/pop/peek at the top.
    private static void demonstrateStack() {
        System.out.println("===== Stack (legacy, extends Vector) =====");
        CollectionTypeInspector.printTypeInfo(Stack.class, Vector.class, List.class);
        CollectionTypeInspector.printDefaultInitialCapacity("Stack: 10 elements (inherited from Vector's no-arg constructor)");
        Stack<String> stack = new Stack<>();

        // Basic methods
        stack.push("Ram");               // push(E) -> add at top, O(1) amortized
        stack.push("Shyam");
        stack.push("Geeta");
        System.out.println("After push(): " + stack);

        System.out.println("peek(): " + stack.peek());          // O(1) - look at top without removing
        System.out.println("search(\"Ram\"): " + stack.search("Ram")); // 1-based distance from the top, O(n)

        stack.pop();                     // pop() -> remove and return top, O(1)
        System.out.println("After pop(): " + stack);

        // Cursor: Iterator - traverses bottom-to-top (insertion order), not top-to-bottom LIFO order
        System.out.println("Iterator traversal (bottom-to-top insertion order):");
        Iterator<String> iterator = stack.iterator();
        while (iterator.hasNext()) {
            System.out.println("  " + iterator.next());
        }

        System.out.println("Core characteristic: LIFO access via push()/pop()/peek() on top of Vector's storage,");
        System.out.println("so it inherits Vector's synchronization overhead; prefer ArrayDeque for new LIFO stack code.");
    }

}
