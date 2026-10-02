package com.concurrentCollection.copyOnWriteArrayListClass;

import java.util.concurrent.CopyOnWriteArrayList;

public class copyOnWriteArrayListexample {

    public static void main(String[] args) {

        CopyOnWriteArrayList<String> cowl = new CopyOnWriteArrayList<>();

        cowl.add("Yudhistara");
        cowl.add("Bhima");
        cowl.add("Arjuna");
        cowl.add("Nakula");
        cowl.add("Sahadeva");

        System.out.println("CopyOnWriteArrayList contents: " + cowl);

        cowl.addIfAbsent("Draupadi");
        cowl.addIfAbsent("Arjuna");

        System.out.println("CopyOnWriteArrayList contents after addIfAbsent: " + cowl);

        CopyOnWriteArrayList<String> cowl1 = new CopyOnWriteArrayList<>(cowl);

        cowl1.add("Abhimanyu");
        cowl1.add("Saathyaki");
        cowl1.add("Shikhandi");
        cowl1.add("Bhima");

        cowl.addAllAbsent(cowl1);

        System.out.println("CopyOnWriteArrayList contents after addAllAbsent: " + cowl);

    }

}
