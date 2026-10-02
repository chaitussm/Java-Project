package com.concurrentCollection.concurrentMap;

public class CustomConcurrentMap extends ConcurrentMapDemo {

    public static void demonconcurrentMap(String collectionType) {
        concurrentCollectionType(collectionType);
        concurrentConstructors(collectionType);
        if (collectionType.equals("ConcurrentHashMap") || collectionType.equals("ConcurrentSkipListMap")
                || collectionType.equals("CustomConcurrentMap")) {
            concurrentMapLoadFactor(collectionType);
        }
    }

    public static void main(String[] args) {
        demonconcurrentMap("CustomConcurrentMap");
    }

}
