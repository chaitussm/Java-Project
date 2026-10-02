package com.javaIOPackage.FileBasics;

import java.io.File;

import com.javaIOPackage.baseMethodsInFileOperations.FileBasicMethods;

public class DisplayFilesAndDirectories extends FileBasicMethods{


    public static void countOfDirectoryAndFiles(String directory)
    {
        int count = 0;

        File file = new File(directory);

        String[] filelist = file.list();

        for(String data : filelist)
        {
           System.out.println("Files and directories inside : " + data);
           count++;
        }
        
        System.out.println("Count of the files and directories : " + count);
    }

    public static void main(String[] args) throws Exception
    {
        String directory = searchFolder("demo");

        countOfDirectoryAndFiles(directory);
    }
    
}
