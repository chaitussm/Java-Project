package com.javaIOPackage.FileBasics;

import java.io.File;

import com.javaIOPackage.baseMethodsInFileOperations.fileBasicMethods;

public class displayFilesAndDirectories extends fileBasicMethods{


    public static void countOfDirectoryAndFiles(String Directory)
    {
        int count = 0;

        File file = new File(Directory);

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
        String Directory = searchFolder("demo");

        countOfDirectoryAndFiles(Directory);
    }
    
}
