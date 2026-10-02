package com.concurrentCollection.copyOnWriteArrayListClass;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.CopyOnWriteArrayList;

import com.concurrentCollection.concurrentCollectionTypeInspector;

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

        // 1. Default Empty Constructor
        // Creates an empty list backed by an internal array of size 0.
        CopyOnWriteArrayList<String> list1 = new CopyOnWriteArrayList<>();
        System.out.println(" -> Created an empty CopyOnWriteArrayList.");

        // 2. Collection Constructor
        // Creates a list containing the elements of the specified collection,
        // in the exact order they are returned by the collection's iterator.
        Collection<String> traditionalList = new ArrayList<>();
        traditionalList.add("Apple");
        traditionalList.add("Banana");

        CopyOnWriteArrayList<String> list2 = new CopyOnWriteArrayList<>(traditionalList);
        System.out.println(" -> Created from an existing Collection. Initial elements: " + list2);

        // 3. Array Constructor
        // Creates a list holding a copy of the given array.
        String[] itemArray = { "Pomegranate", "Orange", "Mango" };

        CopyOnWriteArrayList<String> list3 = new CopyOnWriteArrayList<>(itemArray);
        System.out.println(" -> Created from an existing Array. Initial elements: " + list3);

    }

    public static void demonstrateCopyOnWriteArrayList() {

        concurrentCollectionTypeInspector.printDefaultCapacitySummary("CopyOnWriteArrayList");
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
