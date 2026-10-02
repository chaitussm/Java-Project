package com.javaIOPackage.mergeFiles;

import java.io.*;
import com.javaIOPackage.baseMethodsInFileOperations.fileBasicMethods;

public class fileMerger extends fileBasicMethods {

    /*
     * The try-with-resources statement works automatically because it is built
     * directly into the Java compiler. Under the hood, Java transforms your
     * clean code into a secure, automated cleanup process.
     *
     * Here is how it functions step by step:
     *
     * 1. The secret interface: AutoCloseable
     *    - Any class placed inside the try (...) parentheses must implement the
     *      built-in java.lang.AutoCloseable interface.
     *    - Classes such as PrintWriter, BufferedReader, and FileReader implement
     *      this interface.
     *    - AutoCloseable guarantees that these classes provide a standard
     *      close() method.
     *
     * 2. What the compiler does behind the scenes
     *    - When you compile the code, Java translates the try-with-resources
     *      block into a traditional try-finally structure.
     *    - If the compiled bytecode were converted back into Java, the code
     *      would look similar to this behind the scenes:
    *
    *      // What the compiler builds for you automatically:
    *      PrintWriter pw = new PrintWriter(finalfile);
    *      Throwable primaryException = null;
    *      try {
    *          // Your file merging loop logic runs here...
    *      } catch (Throwable t) {
    *          primaryException = t;
    *          throw t;
    *      } finally {
    *          // The automatic cleanup phase:
    *          if (pw != null) {
    *              if (primaryException != null) {
    *                  try {
    *                      pw.close(); // Automatically flushes and closes!
    *                  } catch (Throwable suppressed) {
    *                      // Keeps track of all cleanup errors.
    *                      primaryException.addSuppressed(suppressed);
    *                  }
    *              } else {
    *                  pw.close();
    *              }
    *          }
    *      }
    *
    * 3. Why you do not need flush()
    *    - For classes such as PrintWriter or BufferedWriter, calling close()
    *      automatically calls flush() first.
    *    - Because Java is guaranteed to call the hidden close() method inside
    *      the finally block, the remaining data is safely pushed out of memory
    *      and saved to the file before the stream shuts down.
    *
    * 4. The order of closing
    *    - When you declare multiple streams, Java tracks them like a stack of
    *      plates. It closes them in the reverse order in which they were opened:
    *
    *      1. br2 is closed first.
    *      2. br1 is closed second.
    *      3. pw is closed last.
     */


    public static void mergeFiles(String finalfile, String firstfile, String secondfile) throws IOException {
        
        // Open all 3 resources safely. Separated by semicolons.
        try (PrintWriter pw = new PrintWriter(finalfile);
             BufferedReader br1 = new BufferedReader(new FileReader(firstfile));
             BufferedReader br2 = new BufferedReader(new FileReader(secondfile))) {
            
            // Read and write the first file
            String data = br1.readLine();
            while (data != null) {
                pw.println(data);
                data = br1.readLine();
            }

            // Read and write the second file
            data = br2.readLine();
            while (data != null) {
                pw.println(data);
                data = br2.readLine();
            }
            
        } // All 3 streams are guaranteed to close safely here, even if an error occurs!
    }




    public static void main(String[] args) throws Exception
    {
        mergeFiles(sampleDataPath("file-operations", "mergedFile.txt").toString(),
            sampleDataPath("file-operations", "BufferedData.txt").toString(),
            sampleDataPath("file-operations", "enhancedWriter.txt").toString());
    }
    
}
