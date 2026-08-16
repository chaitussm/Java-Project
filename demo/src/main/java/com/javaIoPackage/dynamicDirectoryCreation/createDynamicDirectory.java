package com.javaIoPackage.dynamicDirectoryCreation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class createDynamicDirectory {


    public static void main(String[] args)
    {
        /*Dynamically targets a folder named "/FileOperations" inside your project root*/
       
        // 1. Get the dynamic cross-platform user home path (e.g., C:\Users\Username or /Users/username)
        //String userHome = System.getProperty("user.home"); inside the braces home means home folder dir means in the current directory
       
        String userHome = System.getProperty("user.dir");
        
        // 2. Safely stitch the path components using Path.of() to avoid system separator issues
        Path dynamicDirectory = Path.of(userHome, "Documents", "JavaDynamicOutputs");
        
        // 3. Generate a dynamic filename using the current timestamp to ensure uniqueness
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String uniqueFileName = "log_" + timestamp + ".txt";
        
        // 4. Resolve the absolute path for the new file
        Path absoluteFilePath = dynamicDirectory.resolve(uniqueFileName);

        try {
            // 5. Create directories recursively if they don't exist yet (simulates 'mkdir -p')
            Files.createDirectories(dynamicDirectory);
            System.out.println("📂 Target folder verified at: " + dynamicDirectory.toAbsolutePath());

            // 6. Create the empty file dynamically
            Files.createFile(absoluteFilePath);
            System.out.println("📄 Unique file generated at:  " + absoluteFilePath.toAbsolutePath());
            
            // 7. Optional: Write a quick dynamic initialization message to the file
            String initialContent = "File initialized dynamically on: " + LocalDateTime.now() + "\n";
            Files.writeString(absoluteFilePath, initialContent);
            System.out.println("✍️ Successfully populated file headers.");

        } catch (IOException e) {
            System.err.println("❌ Critical IO Error encountered during execution:");
            e.printStackTrace();
        }

    }
    
}
