package com.concurrentCollection.copyOnWriteArraySetClass;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class copyOnWriteArraySetexample {

    public static void main(String[] args) {

        CopyOnWriteArraySet<String> cowl = new CopyOnWriteArraySet<>();

        cowl.add("Yudhistara");
        cowl.add("Bhima");
        cowl.add("Arjuna");
        cowl.add("Nakula");
        cowl.add("Sahadeva");
        cowl.add(null);

        System.out.println("CopyOnWriteArraySet contents: " + cowl);

    }

}
