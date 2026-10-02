package com.concurrentCollection.concurrentMap;

public class CustomConcurrentHashMap extends ConcurrentMapDemo {

    public static void demonconcurrentMap(String collectionType) {
        concurrentCollectionType(collectionType);
        concurrentConstructors(collectionType);
        if (collectionType.equals("CustomConcurrentHashMap") || collectionType.equals("ConcurrentSkipListMap")
                || collectionType.equals("ConcurrentMap")) {
            concurrentMapLoadFactor(collectionType);
        }
    }

    public static void main(String[] args) {
        demonconcurrentMap("CustomConcurrentHashMap");
    }

}
