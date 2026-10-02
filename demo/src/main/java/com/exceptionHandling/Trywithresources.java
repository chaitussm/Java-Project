package com.exceptionHandling;

public class trywithresources {

    /*from java 1.7v we are using try-with-resources statement to automatically close the resource so no need of the finally is not needed */
    public static void main(String[] args) {
        // Using try-with-resources to automatically close the resource
        try (java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader("test.txt"))) {
        /*all resource reference variables inside the part of try-with-resources are implicitlyfinal
        all the resources inside the resources block are automatically closed*/
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (java.io.IOException e) {
            System.out.println("An I/O error occurred: " + e.getMessage());
        }
    }
    
}
