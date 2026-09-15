package com.collections.properties;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class createProperties {

    public static void createDefaultProperties() {
        Properties properties = new java.util.Properties();

       try(FileInputStream fis = new FileInputStream("propertiesDemo.properties");
           FileOutputStream fos = new FileOutputStream("propertiesDemo.properties");) {
           properties.load(fis);

           System.out.println("Properties loaded: " + properties);

           properties.forEach((key, value) -> System.out.println(key + " = " + value));

           String data = properties.getProperty("");

           System.out.println("Value of 'value3': " + data);

           properties.setProperty("value4", "Subrahmanya");

           properties.setProperty("value5", "Ganesha");

           properties.store(fos, "Updated Properties");
           fos.close();


       } catch (java.io.IOException e) {
           e.printStackTrace();
       }
    }

    public static void main(String[] args) {
        createDefaultProperties();
    }
    
}
