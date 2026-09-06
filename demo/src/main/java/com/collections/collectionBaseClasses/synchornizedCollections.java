package com.collections.collectionBaseClasses;

import java.util.*;

public class synchornizedCollections {

    // Collections.synchronizedList() wraps a List so every method is internally synchronized
    public void demonstrateSynchronizedList() {
        List<String> list = new ArrayList<>();
        List<String> syncList = Collections.synchronizedList(list);
        synchronized (syncList) {
            syncList.add("item1");
            syncList.add("item2");
        }
        System.out.println("Synchronized List: " + syncList);
    }

    // Collections.synchronizedSet() wraps a Set so every method is internally synchronized
    public void demonstrateSynchronizedSet() {
        Set<String> set = new HashSet<>();
        Set<String> syncSet = Collections.synchronizedSet(set);
        synchronized (syncSet) {
            syncSet.add("item1");
            syncSet.add("item2");
        }
        System.out.println("Synchronized Set: " + syncSet);
    }

    // Collections.synchronizedSortedSet() wraps a SortedSet so every method is internally synchronized
    public void demonstrateSynchronizedSortedSet() {
        SortedSet<String> sortedSet = new TreeSet<>();
        SortedSet<String> syncSortedSet = Collections.synchronizedSortedSet(sortedSet);
        synchronized (syncSortedSet) {
            syncSortedSet.add("banana");
            syncSortedSet.add("apple");
        }
        System.out.println("Synchronized SortedSet: " + syncSortedSet);
    }

    // Collections.synchronizedMap() wraps a Map so every method is internally synchronized
    public void demonstrateSynchronizedMap() {
        Map<String, String> map = new HashMap<>();
        Map<String, String> syncMap = Collections.synchronizedMap(map);
        synchronized (syncMap) {
            syncMap.put("key1", "value1");
            syncMap.put("key2", "value2");
        }
        System.out.println("Synchronized Map: " + syncMap);
    }

    // Collections.synchronizedSortedMap() wraps a SortedMap so every method is internally synchronized
    public void demonstrateSynchronizedSortedMap() {
        SortedMap<String, String> sortedMap = new TreeMap<>();
        SortedMap<String, String> syncSortedMap = Collections.synchronizedSortedMap(sortedMap);
        synchronized (syncSortedMap) {
            syncSortedMap.put("b", "banana");
            syncSortedMap.put("a", "apple");
        }
        System.out.println("Synchronized SortedMap: " + syncSortedMap);
    }

    // Collections.synchronizedCollection() wraps any Collection so every method is internally synchronized
    public void demonstrateSynchronizedCollection() {
        List<String> collection = new ArrayList<>();
        java.util.Collection<String> syncCollection = Collections.synchronizedCollection(collection);
        synchronized (syncCollection) {
            syncCollection.add("item1");
            syncCollection.add("item2");
        }
        System.out.println("Synchronized Collection: " + syncCollection);
    }

    public static void main(String[] args) {
        synchornizedCollections demo = new synchornizedCollections();
        demo.demonstrateSynchronizedList();
        demo.demonstrateSynchronizedSet();
        demo.demonstrateSynchronizedSortedSet();
        demo.demonstrateSynchronizedMap();
        demo.demonstrateSynchronizedSortedMap();
        demo.demonstrateSynchronizedCollection();
    }
}
