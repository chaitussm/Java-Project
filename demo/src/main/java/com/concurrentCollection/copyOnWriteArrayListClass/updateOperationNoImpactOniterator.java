package com.concurrentCollection.copyOnWriteArrayListClass;

import java.util.Iterator;

import java.util.concurrent.CopyOnWriteArrayList;

public class updateOperationNoImpactOniterator {

    public static void demonstrateUpdateOperationNoImpactOnIterator() {

        CopyOnWriteArrayList<String> coal = new CopyOnWriteArrayList<>();
        coal.add("Kripacharaya");
        coal.add("Dronacharya");
        coal.add("Vidhura");
        coal.add("Sanjaya");

        Iterator<String> iterator = coal.iterator();

        coal.add("Bhishma");
        while (iterator.hasNext()) {
            String element = iterator.next();
            // In output the iterator will not reflect the newly added element "Bhishma"
            // Even if we update the element "Bhishma" to "Bhishma-updated", the iterator
            // will still not reflect this change
            // Thats why old elements only printed by the iterator
            if (element.equals("Bhishma"))
                coal.set(coal.indexOf(element), "Bhishma-updated");
            System.out.println("Current element: " + element);
        }

    }

    public static void main(String[] args) {
        demonstrateUpdateOperationNoImpactOnIterator();
    }
}