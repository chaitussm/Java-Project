package com.javaIOPackage.dynamicDirectoryCreation;

import java.io.IOException;


import com.javaIOPackage.baseMethodsInFileOperations.FileBasicMethods;

public class CreateFileInExistingFolder extends FileBasicMethods{


    
    public static void main(String[] args) throws IOException
    {
        createFileInCurrentDirectory("firstfile");
    }
    
    
}
