package com.concurrentCollection.copyOnWriteArraySetClass;

public class copyOnWriteArraySet {

    public static void demonstratecopyOnWriteArraySet(String collectionType) {
        copyOnWriteArrayListDemo.concurrentCollectionType(collectionType);
        copyOnWriteArrayListDemo.concurrentConstructors(collectionType);
        if (collectionType.equals("CopyOnWriteArrayList")) {
            // Add any specific logic for CopyOnWriteArrayList if needed
        }
    }

    public static void main(String[] args) {
        demonstratecopyOnWriteArraySet("CopyOnWriteArrayList");
    }

}
