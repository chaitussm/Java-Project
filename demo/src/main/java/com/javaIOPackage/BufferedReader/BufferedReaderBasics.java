package com.javaIOPackage.BufferedReader;

import java.io.*;
import com.javaIOPackage.baseMethodsInFileOperations.fileBasicMethods;

public class BufferedReaderBasics extends fileBasicMethods {

    /*
     *
     *
     * We can use BufferedReader to read character data from the file , the main advantage of the BufferedReader when compared with 
     * FileReader is we can read data line-by-line in addition to character by character 
     * Constructors
     * BufferedReader br = new BufferedReader(Reader r);
     * BufferedReader br = new BufferedReader(Reader r, int bufferSize);
     * NOTE: BufferedReader cant communicate directly with the file and it can communicate via some reader Object 
     * Methods 
     * int read()
     * int read(char[] ch)
     * void close()
     * String readLine() : It attempts to read the next line from the file and returns it if the nextlien is not available then this method 
     * returns null 
     * NOTE: whenever we are closing the BufferedReader automatically underlying FileReader will be closed and we are not required to close explicitly.
     * NOTE: The most enhanced reader to read character data from the file is BufferedReader
     */

    public static void main(String[] args) throws Exception
    {
      FileReader fr = new FileReader(sampleDataPath("file-operations", "BufferedData.txt").toFile());

       BufferedReader br = new BufferedReader(fr);

       String data = br.readLine();

       while(data!= null)
       {
          System.out.println(data);

          data = br.readLine();
       }

       br.close();
    }
    
}
