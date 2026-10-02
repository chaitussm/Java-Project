package com.concurrentCollection.copyOnWriteArraySetClass;

public class CustomCopyOnWriteArraySet {

    public static void demonstratecopyOnWriteArraySet(String collectionType) {
        CopyOnWriteArrayListDemo.concurrentCollectionType(collectionType);
        CopyOnWriteArrayListDemo.concurrentConstructors(collectionType);
        if (collectionType.equals("CopyOnWriteArrayList")) {
            // Add any specific logic for CopyOnWriteArrayList if needed
        }
    }

    public static void main(String[] args) {
        demonstratecopyOnWriteArraySet("CopyOnWriteArrayList");
    }

}
