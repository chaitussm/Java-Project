package com.collection.hashTable.basicflow;

public class hashTableDemo {

    public static void main(String[] args) {

        java.util.Hashtable<Object, String> table = new java.util.Hashtable<>();
        table.put(new hashTableBase(5), "value1");
        table.put(new hashTableBase(2), "value2");
        table.put(new hashTableBase(6), "value3");
        table.put(new hashTableBase(15), "value4");
        table.put(new hashTableBase(23), "value5");
        table.put(new hashTableBase(16), "value6");

        //table.put("durga", null) NullPointerException because Hashtable does not allow null values for keys or values
        // insertion order is not preserved in Hashtable
        System.out.println("Hashtable: " + table);
    }
}
