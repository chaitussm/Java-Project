package com.concurrentCollection.concurrentMap;

import java.util.concurrent.ConcurrentHashMap;

public class concurrentHashMapExample {

    public static void main(String[] args) {

        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();

        map.put(100, "Shiva");

        map.put(101, "Parvathi");

        map.putIfAbsent(101, "Kaali");

        map.putIfAbsent(102, "Ganesha");

        map.remove(103, "SomeValue");

        map.replace(100, "Shiva", "Mahadeva");

        System.out.println(map);
    }
}
