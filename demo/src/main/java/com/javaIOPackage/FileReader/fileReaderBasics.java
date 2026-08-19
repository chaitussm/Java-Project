package com.javaIOPackage.FileReader;

import java.io.*;

public class fileReaderBasics {

    /*
     *
     *
     * We can use FileReader to read character data from the file 
     * Constructors
     * FileReader fr = new FileReader(String filename);
     * FileReader fr = new FileReader(File f);
     * Methods 
     * int read() : It attempts to read next character from the file and returns its unicode value 
     * if the next character is not available then this method returns -1 
     * as this method returns unicode value(int value), at the time of printing we have to perfom Type Casting
     * int read(char[] ch) : its attempts to read enough characters from the file into char array and returns number of 
     * characters copied from the file.
     * usage of FileWriter
     */
    public static void readMethod() throws Exception
    {
         FileReader fr = new FileReader("writeData.txt");

         int value = fr.read();

         System.out.println(value);

         while(value !=-1)
         {
           System.out.println((char)value);//type casting the int value to get the exact characterd which is read

           value = fr.read();

         }
    }

    public static void readMethodWithCharArray() throws Exception
    {
        File file = new File("writeData.txt");
        
        char[] ch = new char[(int)file.length()];//if the range is more than int range then use read() only 

        FileReader fr = new FileReader(file);

        fr.read(ch);

        for(char ch1 : ch)
        {
           System.out.println(ch1);
        }

    }
    public static void main(String[] args) throws Exception
    {
       readMethod();
       readMethodWithCharArray();
    }
}
