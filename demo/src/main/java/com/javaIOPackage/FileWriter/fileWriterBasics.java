package com.javaIOPackage.FileWriter;

import java.io.File;
import java.io.FileWriter;

import com.javaIOPackage.baseMethodsInFileOperations.fileBasicMethods;
public class fileWriterBasics extends fileBasicMethods{

    /*
     *
     *
     * We can use FileWriter to write character data to the file
     * FileWriter fw = new FileWriter(String fileName)
     * FileWriter fw = new FileWriter(File f)
     * The above FileWriter constructors meant for overriding of existing data instead of overriding if we want append operation 
     * then we have to create FileWriter by using the following constructors 
     * FileWriter fw = new FileWriter(String filename, boolean append)
     * FileWriter fw = new FileWriter(File f, boolean append)
     * NOTE: If the specified file is not already available then all the above constructors will create that file
     * write(int ch) : To write a single character 
     * write(char[] ch) : to write any array of characters 
     * write(String s) : to write String to the file
     * flush() to give the guranteethat total including last character will be written to the file 
     * close() to close the writer 
     * The main problem with the FileWriter is we have to insert line separator '/n' manually
     * which is varied from one OS to other OS  which is difficult for programmer 
     * We can solve this issue by using BufferedWriter and PrintWriter 
     * 
     */

    public static void writeDataToFile() throws Exception
    {
        //to orverride the data at each of execution 
        FileWriter fw = new FileWriter("writeData.txt");

        //to append the data everytime 
       // FileWriter fw = new FileWriter("writeData.txt" , true);

        fw.write(100); //adding a single character 

        fw.write("durga");

        fw.write('\n');

        char[] ch = {'s','h','i','v','a'};

        fw.write(ch);

        fw.write('\n');

        fw.flush();

        fw.close();


    }

    public static void main(String[] args) throws Exception
    {
        searchFile("writeData.txt");
        writeDataToFile();
    }
    
}
