package com.concurrentCollection.copyOnWriteArrayListClass;

public class copyOnWriteArrayList {

    public static void demonstratecopyOnWriteArrayList(String collectionType) {
        copyOnWriteArrayListDemo.concurrentCollectionType(collectionType);
        copyOnWriteArrayListDemo.concurrentConstructors(collectionType);
        if (collectionType.equals("CopyOnWriteArrayList")) {
            // Add any specific logic for CopyOnWriteArrayList if needed
        }
    }

    public static void main(String[] args) {
        demonstratecopyOnWriteArrayList("CopyOnWriteArrayList");
    }

}
