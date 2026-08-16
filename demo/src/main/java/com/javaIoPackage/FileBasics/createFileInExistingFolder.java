package com.javaIoPackage.FileBasics;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class createFileInExistingFolder {


    /*
     * File f = new File(String name);
     * Creates a java file Object to represent name of the file or directory in current working directory
     * File f = new File(String subdirname, String name)
     * Creates a java file Object to represent name of the file or directory present in specified subdirectory 
     * File f = new File(File subdir, String name)
     */
    
    public static void createFileInCurrentDirectory(String filename) 
    {
       // 1. Get project root path
        String projectRoot = System.getProperty("user.dir");

        // 2. Fixed folder path (Created once, reused every time)
        String folderPath = projectRoot + File.separator + "FileOperations" + File.separator + "SharedOutputFolder"; 

        // 3. Dynamic file name (A brand new file name on every single run!)
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String uniqueFileName =  filename + timestamp + ".txt";

        // 4. Combine the reused folder with the brand new file name
        File file = new File(folderPath, uniqueFileName);

        try {
            // 5. Reuse or create the folder
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
                System.out.println("📂 Created folder for the first time: " + file.getParentFile().getAbsolutePath());
            } else {
                System.out.println("🔄 Reusing existing folder: " + file.getParentFile().getAbsolutePath());
            }

            // 6. Create the brand new file inside that folder
            if (file.createNewFile()) {
                System.out.println("📄 Created brand new file: " + file.getName());
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws IOException
    {
        createFileInCurrentDirectory("firstfile");
    }
    
    
}
