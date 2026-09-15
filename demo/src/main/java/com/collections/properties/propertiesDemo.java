package com.collections.properties;

import java.util.Properties;
import java.util.TreeSet;

import com.collections.collectionBaseClasses.CollectionTypeInspector;

public class propertiesDemo {
    public static void main(String[] args) {

        java.util.Properties properties = new java.util.Properties();
        properties.put(new propertiesBase("key1", "Shiva").getKey(), new propertiesBase("key1", "Brahma").getValue());
        properties.put(new propertiesBase("key2", "Vishnu").getKey(), new propertiesBase("key2", "Vishnu").getValue());
        properties.put(new propertiesBase("key3", "Brahma").getKey(), new propertiesBase("key3", "Shiva").getValue());
        /*properties.setProperty("key4", null); NullPointerException will be thrown
        properties.setProperty("key4", "value4");
        try {
            properties.store(new java.io.FileWriter("propertiesDemo.properties"), "Properties Demo");
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }*/
        //properties.notify();java.lang.IllegalMonitorStateException: current thread is not owner
        properties.getProperty("key1");
        properties.propertyNames();
        for (String key : properties.stringPropertyNames()) {
            System.out.println(key + " = " + properties.getProperty(key));
        }
        CollectionTypeInspector.printTypeInfo(properties.getClass(), Properties.class);
        CollectionTypeInspector.printDefaultInitialCapacity("Properties");

        // insertion order is not preserved in Properties
        System.out.println("Properties: " + properties);
    }
}
