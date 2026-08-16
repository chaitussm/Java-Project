package com.javaIoPackage.FileBasics;

import java.io.*;

public class fileInIOpackage {

    public static void main(String[] args) throws IOException
    {
        File f = new File("FirstFile.txt");

        /* The above line won't create any physical file , first it will check is there any physical file named with 
         * "FirstFile.txt" is available or not if it is available the f simply refers that file.
         * If it is not available then we are just creating java file object to represent the name "FirstFile.txt"
         * We can use java file object to represent directory also 
         */

        System.out.println(f.exists());

        Boolean status = f.createNewFile();

        System.out.println(f.exists());

        System.out.println(status);

        f.mkdir();
        
        System.out.println(f.exists());

        /*NOTE : In Unix everything is treated as a file , java file Io Concept is implemented based on Unix operating System
          Hence java file Object can be used to represent both files and directories */

        
    }
    
}
