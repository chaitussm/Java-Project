package com.javaIOPackage.baseMethodsInFileOperations;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.EnumSet;
import java.util.Optional;
import java.util.stream.Stream;

public class fileBasicMethods {

    /*To Create dynamic directory*/

    public static void createDynamicDirectory()
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
    
    public static void searchDirectory(String targetDirName)
    {
       // 1. Define the search starting root and the directory name you want to find
        Path searchRoot = Path.of(System.getProperty("user.home"));

        System.out.println("🔍 Searching for directory '" + targetDirName + "' starting from: " + searchRoot.toAbsolutePath());

        try {
            // 2. Traverse the directory tree looking for matching folders
            Files.walkFileTree(searchRoot, EnumSet.noneOf(FileVisitOption.class), Integer.MAX_VALUE, new SimpleFileVisitor<Path>() {
                
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
                    // Check if the current directory name matches the target
                    if (dir.getFileName() != null && dir.getFileName().toString().equalsIgnoreCase(targetDirName)) {
                        System.out.println("📂 Found Directory: " + dir.toAbsolutePath());
                    }
                    return FileVisitResult.CONTINUE; // Keep searching deeper
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) {
                    // Gracefully skip restricted system folders
                    return FileVisitResult.SKIP_SUBTREE;
                }
            });

        } catch (IOException e) {
            System.err.println("❌ Error traversing directory tree: " + e.getMessage());
        }
        
        System.out.println("🏁 Directory search finished.");
    }
    
    public  static void searchFile(String targetFileName)
    {
        // 1. Set the search starting point to the entire user home directory 
        // (Change to "C:/" or "/" if you truly want to scan the whole hard drive)
        String searchRoot = System.getProperty("user.home");
        

        Path startPath = Path.of(searchRoot);

        System.out.println("🔍 Scanning entire directory starting from: " + startPath.toAbsolutePath());
        long startTime = System.currentTimeMillis();

        // 2. Walk through the entire directory tree safely
        try (Stream<Path> pathStream = Files.walk(startPath)) {
            Optional<Path> foundFile = pathStream
                    .filter(Files::isRegularFile)
                    .filter(path -> path.getFileName().toString().equalsIgnoreCase(targetFileName))
                    .findFirst(); // Stops searching as soon as it finds the first match

            if (foundFile.isPresent()) {
                System.out.println("✅ File found at: " + foundFile.get().toAbsolutePath());
            } else {
                System.out.println("⚠️ File not found anywhere in this directory tree.");
            }

        } catch (IOException e) {
            // Note: AccessDeniedExceptions can happen if Java hits restricted system files
            System.err.println("⚠️ Notice during scan (some folders may be restricted): " + e.getMessage());
        }

        long endTime = System.currentTimeMillis();
        System.out.println("⏱️ Search completed in " + (endTime - startTime) + " ms.");
        
    }

    public  static String searchFolder(String targetFolder)
    {
         // Gets the current project root path
        String projectPath = System.getProperty("user.dir");
       
        // Combine project path with the target folder
        File directory = new File(projectPath, targetFolder);
        
        // Check if the folder exists inside the project
        if (directory.exists() && directory.isDirectory()) {
            System.out.println("Folder found at: " + directory.getAbsolutePath());
        } else {
            System.out.println("Folder not found in the project path.");
        }

        return directory.toString();
    }

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

    
}
