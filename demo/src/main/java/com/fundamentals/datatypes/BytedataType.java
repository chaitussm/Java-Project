package com.fundamentals.datatypes;

public class BytedataType {

    public static void bytedeclaration()
    {
         // Declare a byte variable and assign a value
        byte myByte = 100;

        // Print the value of the byte variable
        System.out.println("The value of myByte is: " + myByte);

        // Demonstrating the range of byte data type
        byte minByte = -128; // Minimum value of byte
        byte maxByte = 127;  // Maximum value of byte

        System.out.println("Minimum value of byte: " + minByte);
        System.out.println("Maximum value of byte: " + maxByte);

        // Default value of a byte
        byte defaultByte = 0;
        System.out.println("Default value of byte: " + defaultByte);
    }

      /**
     * Writes an array of bytes to the specified file using FileOutputStream.
     */
    public static void writeBytesToFile(String filename, byte[] data) {
        try (java.io.FileOutputStream fos = new java.io.FileOutputStream(filename)) {
            fos.write(data);
            System.out.println("Wrote " + data.length + " bytes to " + filename);
        } catch (java.io.IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    /**
     * Reads bytes from the specified file using FileInputStream and prints them.
     */
    public static void readBytesFromFile(String filename) {
        try (java.io.FileInputStream fis = new java.io.FileInputStream(filename)) {
            int b;
            System.out.print("Read bytes:");
            while ((b = fis.read()) != -1) {
                System.out.print(" " + b);
            }
            System.out.println();
        } catch (java.io.IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
    }

    public static void main(String[] args) 
    {
        bytedeclaration();
        
        String filename = "bytes.bin";
        byte[] data = {10, 20, 30, 40, 50};
        writeBytesToFile(filename, data);
        readBytesFromFile(filename);
    }
    
  
}
