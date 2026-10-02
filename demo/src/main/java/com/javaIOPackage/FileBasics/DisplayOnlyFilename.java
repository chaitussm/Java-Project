package com.javaIOPackage.FileBasics;

import java.io.File;

import com.javaIOPackage.baseMethodsInFileOperations.fileBasicMethods;

public class displayOnlyFilename extends fileBasicMethods{

  public static void fetchOnlyFilename(String directory)
  {
      int count = 0;

      File file = new File(directory);

      String[] filelist = file.list();

      for(String data : filelist)
      {
         File f = new File(file,data);
         if(f.isFile())
         {
           System.out.println("Files in the folder are :" + data);
           count++;
         }
      }

      System.out.println("Count of files in folder is :" + count);
  }

  public static void fetchOnlyFileName(String directory)
  {
      int count = 0;

      File file = new File(directory);

      File[] filelist = file.listFiles();

      for(File files : filelist)
      {
         if(files.isFile())
         {
           System.out.println("Files in the folder are :" + files);
           count++;
         }
      }
      
    System.out.println("Count of files in folder is :" + count);

  }

  public static void main(String[] args)
  {
     String directory = searchFolder("demo");
    
     fetchOnlyFilename(directory);

     fetchOnlyFileName(directory);

  }
    
}
