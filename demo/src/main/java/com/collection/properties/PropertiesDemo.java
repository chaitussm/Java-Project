package com.collection.properties;

import java.util.Properties;

import com.collection.collectionBaseClasses.CollectionTypeInspector;

public class PropertiesDemo {
    public static void main(String[] args) {

        java.util.Properties properties = new java.util.Properties();
        properties.put(new PropertiesBase("key1", "Shiva").getKey(), new PropertiesBase("key1", "Brahma").getValue());
        properties.put(new PropertiesBase("key2", "Vishnu").getKey(), new PropertiesBase("key2", "Vishnu").getValue());
        properties.put(new PropertiesBase("key3", "Brahma").getKey(), new PropertiesBase("key3", "Shiva").getValue());
        /*properties.setProperty("key4", null); NullPointerException will be thrown
        properties.setProperty("key4", "value4");
        try {
            properties.store(new java.io.FileWriter("PropertiesDemo.properties"), "Properties Demo");
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
