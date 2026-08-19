package com.javaIOPackage.BufferedWriter;

import java.io.*;

public class BufferWriter {

    /*
     * We can use Buffered writer to write character data to the file 
     * Constructors
     * BufferWriter bw = new BufferedWriter(Writer w)
     * BufferWriter bw = new BufferedWriter(Writer w , int bufferSize)
     * NOTE: BuffredWriter cant communicate directly with the file , it can communicate via some writer Object 
     * BufferWriter bw = new BufferedWriter(new FileWriter(String filename));
     * BufferWriter bw = new BufferedWriter(new BufferWriter(new FileWriter(String filename)));
     * Methods 
     * write(), write(char[] ch), write(String s)
     * flush() , close(), newLine()
     * NOTE: whenever we are closing BuffredWriter automatically internal FileWriter will be closed and we are not required to close explicitly 
     * 
     */

    public static void main(String[] args) throws Exception
    {
       FileWriter fw = new FileWriter("BufferedData.txt");

       BufferedWriter bw = new BufferedWriter(fw);

       bw.write(100);

       bw.newLine();

       char[] ch1 = {'S', 'H', 'I', 'V', 'A'};

       bw.newLine();

       bw.write("shakti");

       bw.newLine();

       bw.write("Shiva");

       bw.flush();

       bw.close();


    }    
}
