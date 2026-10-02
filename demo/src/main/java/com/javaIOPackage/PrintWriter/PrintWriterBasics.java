package com.javaIOPackage.PrintWriter;

import java.io.*;
import com.javaIOPackage.baseMethodsInFileOperations.fileBasicMethods;

public class printWriterBasics extends fileBasicMethods {

    /*
     *
     *
     * PrintWriter: it is most enhanced writer to write character data data to the file 
     * The main advantage of PrintWriter over FileWriter and BufferedWriter is we can write any type of primitive data directly to the file 
     * Constructors
     * PrintWriter pw = new PrintWriter(String filename);
     * PrintWriter pw = new PrintWriter(File file);
     * PrintWriter pw = new PrintWriter(Writer w);
     * PrintWriter can communicate directly with the file and can communicate via some Writer Object also 
     * Methods 
     * write(int ch);
     * write(char[] ch);
     * write(String s);
     * flush();
     * close();
     * print(char ch);
     * print(int i);
     * print(double d);
     * print(boolean b);
     * print(String s);
     * println(char ch);
     * println(int i);
     * println(double d);
     * println(boolean b);
     * println(String s);
     * write(100): here the corresponding chartacter 'd' will be added to the file 
     * print(100): here the int value 100 will be added to the file directly 
     * NOTE: The most enhances writer to write character data to the file is PrintWriter whereas the most enhanaced reader to read character data from
     * the file is BufferedReader
     * NOTE: In general we can use readers and writers to handle character data (text data) , whereas we can use Streams to handle binary data 
     * (like images, videos , pdfs files , audio files and video files)
     * We can use OutputStream to write binary data to the file InputStream to read binary data form the file
     * 
     */
    
    public static void printWriterBasicMethods()
    {
        String fileName = sampleDataPath("file-operations", "enhancedWriter.txt").toString();

        // Try-with-resources automatically closes the PrintWriter and flushes data
        try (PrintWriter writer = new PrintWriter(fileName)) {
            
            // 1. Writing strings with and without newlines
            writer.print(100); 
            writer.println("World!"); // Appends a newline at the end

            char[] ch = {'v', 'i' , 's', 'h', 'n', 'u'};

            writer.print(ch);
            
            // 2. Writing primitive data types directly as formatted text
            writer.println(2026);
            writer.println(99.95);
            writer.println(true);
            
            // 3. Using printf for advanced string formatting
            String name = "Vishnu";
            int score = 95;
            writer.printf("User %s scored %d points.%n", name, score);
            
            System.out.println("Successfully wrote data to " + fileName);
            
        } catch (FileNotFoundException e) {
            System.err.println("Error: Could not create or open the file.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException
    {
        printWriterBasicMethods();

        // Try-with-resources handles closing and forces data to print
        try (PrintWriter pw = new PrintWriter(sampleDataPath("file-operations", "enhancedWriter.txt").toFile())) {
            
            pw.print(100);

            char[] ch = {'v', 'i' , 's', 'h', 'n', 'u'};
            pw.print(ch);

            pw.println(10.5);

            pw.println("vishnu , lakshmi");

            pw.println(true);
            
        } // The file is completely saved and printed right here
        
        System.out.println("File written successfully!");
    }



    
}
