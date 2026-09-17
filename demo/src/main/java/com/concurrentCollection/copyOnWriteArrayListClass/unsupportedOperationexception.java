package com.concurrentCollection.copyOnWriteArrayListClass;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class unsupportedOperationexception {

    public static void demonstrateUnsupportedOperationException() {

        CopyOnWriteArrayList<String> coal = new CopyOnWriteArrayList<>();
        coal.add("gandhari");
        coal.add("kunti");
        coal.add("draupadi");
        coal.add("Subhadra");
        coal.add("yashoda");
        // This will throw UnsupportedOperationException if the list is unmodifiable
        Iterator<String> iterator = coal.iterator();
        while (iterator.hasNext()) {

            String element = iterator.next();
            if (element.equals("yashoda"))
                iterator.remove();
            System.out.println("Removed element: " + element);
        }

    }

    public static void main(String[] args) {
        demonstrateUnsupportedOperationException();
    }
}
