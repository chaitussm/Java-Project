package com.concurrentCollection.copyOnWriteArrayListClass;

public class CustomCopyOnWriteArrayList {

    public static void demonstratecopyOnWriteArrayList(String collectionType) {
        CopyOnWriteArrayListDemo.concurrentCollectionType(collectionType);
        CopyOnWriteArrayListDemo.concurrentConstructors(collectionType);
        if (collectionType.equals("CustomCopyOnWriteArrayList")) {
            // Add any specific logic for CustomCopyOnWriteArrayList if needed
        }
    }

    public static void main(String[] args) {
        demonstratecopyOnWriteArrayList("CustomCopyOnWriteArrayList");
    }

}
