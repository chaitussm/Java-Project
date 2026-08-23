// Places this class inside the FileExtraction package.
package com.javaIOPackage.FileExtraction;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import com.javaIOPackage.baseMethodsInFileOperations.fileBasicMethods;

public class fileExtractionOperation extends fileBasicMethods {

    // Reads the input file and writes only the lines not listed in the delete file.
    public static void extractfiles(String outputfile, String inputfile, String deletedfile)
    {
        // Opens all three files and automatically closes them when this block finishes.
        try(PrintWriter pw = new PrintWriter(outputfile);
            // Opens the original file so its lines can be examined.
            BufferedReader br = new BufferedReader(new FileReader(inputfile));
            // Opens the file containing lines that must be excluded.
            BufferedReader br1 = new BufferedReader(new FileReader(deletedfile));)
          {
            // Creates a set to hold every line that should be removed.
            Set<String> deletedLines = new HashSet<>();
            // Reads the first line from the delete file.
            String deletedLine = br1.readLine();
            // Continues reading until the delete file has no more lines.
            while(deletedLine != null)
            {
                // Stores the current delete-file line in the set.
                deletedLines.add(deletedLine);
                // Moves to the next line so the loop always makes progress.
                deletedLine = br1.readLine();
            }

            // Reads the first line from the original input file.
            String inputfiledata = br.readLine();
            // Processes every line until the end of the input file is reached.
            while(inputfiledata != null)
            {
                // Writes the line only when it does not appear in the delete set.
                if(!deletedLines.contains(inputfiledata))
                {
                    // Writes the retained line and then starts a new line in the output file.
                    pw.println(inputfiledata);
                }

                inputfiledata = br.readLine();
            }

          }

         catch(IOException e)
         {
            System.out.println("File not Found exception");
         }

        
    }

    // Approach 2: compares the files without using a collection.
    public static void extractfilesWithoutCollection(String outputfile, String inputfile, String deletedfile)
    {
        try(BufferedReader inputReader = new BufferedReader(new FileReader(inputfile));
            BufferedReader deletedReader = new BufferedReader(new FileReader(deletedfile));
            PrintWriter outputWriter = new PrintWriter(outputfile))
        {
            // Stores all delete-file lines as complete newline-delimited records.
            StringBuilder deletedText = new StringBuilder("\n");
            String deletedLine;
            while((deletedLine = deletedReader.readLine()) != null)
            {
                deletedText.append(deletedLine).append("\n");
            }

            // Reads every input line and checks whether the delete text contains it.
            String inputLine;
            while((inputLine = inputReader.readLine()) != null)
            {
                String lineWithMarkers = "\n" + inputLine + "\n";
                if(deletedText.indexOf(lineWithMarkers) == -1)
                {
                    outputWriter.println(inputLine);
                }
            }
        }
        catch(IOException e)
        {
            System.out.println("File operation failed: " + e.getMessage());
        }
    }

    public static void main(String[] args) throws Exception
    {
        // Runs the non-collection approach and writes the result to outputFile.txt.
        String sampleData = sampleDataPath("file-operations").toString();
        extractfilesWithoutCollection(sampleData + File.separator + "outputFile.txt",
            sampleData + File.separator + "inputFile.txt",
            sampleData + File.separator + "deleteFile.txt");
    }
    
}
