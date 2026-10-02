package com.concurrentCollection.concurrentMap;

public class concurrentMap extends concurrentMapDemo {

    public static void demonconcurrentMap(String collectionType) {
        concurrentCollectionType(collectionType);
        concurrentConstructors(collectionType);
        if (collectionType.equals("ConcurrentHashMap") || collectionType.equals("ConcurrentSkipListMap")
                || collectionType.equals("ConcurrentMap")) {
            concurrentMapLoadFactor(collectionType);
        }
    }

    public static void main(String[] args) {
        demonconcurrentMap("ConcurrentMap");
    }

}
