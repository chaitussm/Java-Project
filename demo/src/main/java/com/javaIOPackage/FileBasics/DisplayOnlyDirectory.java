package com.javaIOPackage.FileBasics;

import java.io.File;

import com.javaIOPackage.baseMethodsInFileOperations.fileBasicMethods;

public class displayOnlyDirectory extends fileBasicMethods{

    public static void fetchOnlyDirectoryname(String directory)
  {
      int count = 0;

      File file = new File(directory);

      String[] filelist = file.list();

      for(String data : filelist)
      {
         File f = new File(file,data);
         if(f.isDirectory())
         {
           System.out.println("Directory in the folder are :" + data);
           count++;
         }
      }

      System.out.println("Count of directory in folder is :" + count);
  }

  public static void fetchOnlyDirectoryName(String directory)
  {
      int count = 0;

      File file = new File(directory);

      File[] directorieslist = file.listFiles();

      for(File directories : directorieslist)
      {
         if(directories.isDirectory())
         {
           System.out.println("directory in the folder are :" + directories);
           count++;
         }
      }
      
    System.out.println("Count of directory in folder is :" + count);

  }

  public static void main(String[] args)
  {
     String directory = searchFolder("demo");
    
     fetchOnlyDirectoryname(directory);

     fetchOnlyDirectoryName(directory);

  }
    
}
