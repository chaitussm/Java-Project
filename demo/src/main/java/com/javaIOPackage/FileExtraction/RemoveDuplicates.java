package com.javaIOPackage.FileExtraction;

import java.io.*;
import java.util.LinkedHashSet;
import java.util.Set;
import com.javaIOPackage.baseMethodsInFileOperations.fileBasicMethods;

public class removeDuplicates extends fileBasicMethods {

    // Approach 1: checks every input line against the lines already written.
    public static void removeDuplicatesUsingFileScan(String inputFile, String outputFile)
    {
        try(BufferedReader inputReader = new BufferedReader(new FileReader(inputFile));
            PrintWriter outputWriter = new PrintWriter(outputFile))
        {
            String line;

            // Reads each line from the input file.
            while((line = inputReader.readLine()) != null)
            {
                boolean alreadyWritten = false;

                // Flushes the current output so a separate reader can see new data.
                outputWriter.flush();

                // Scans the output file to see whether this line was written before.
                try(BufferedReader outputReader = new BufferedReader(new FileReader(outputFile)))
                {
                    String writtenLine;
                    while((writtenLine = outputReader.readLine()) != null)
                    {
                        if(writtenLine.equals(line))
                        {
                            alreadyWritten = true;
                            break;
                        }
                    }
                }

                // Writes the line only when the scan did not find it.
                if(!alreadyWritten)
                {
                    outputWriter.println(line);
                }
            }
        }
        catch(IOException e)
        {
            System.out.println("File operation failed: " + e.getMessage());
        }
    }

    // Approach 2: stores the unique text in a StringBuilder before writing it.
    public static void removeDuplicatesUsingStringBuilder(String inputFile, String outputFile)
    {
        try(BufferedReader inputReader = new BufferedReader(new FileReader(inputFile)))
        {
            StringBuilder uniqueText = new StringBuilder();
            String line;

            // Reads each input line and adds it only when it is not already present.
            while((line = inputReader.readLine()) != null)
            {
                String lineWithMarkers = "\n" + line + "\n";
                if(uniqueText.indexOf(lineWithMarkers) == -1)
                {
                    uniqueText.append(lineWithMarkers);
                }
            }

            // Writes the prepared unique text to the output file.
            try(PrintWriter outputWriter = new PrintWriter(outputFile))
            {
                outputWriter.print(uniqueText.toString().trim());
                outputWriter.println();
            }
        }

        catch(IOException e)
        {
            System.out.println("File operation failed: " + e.getMessage());
        }
    }

    // Approach 3: uses a collection to keep unique lines in their original order.
    public static void removeDuplicatesUsingCollection(String inputFile, String outputFile)
    {
        try(BufferedReader inputReader = new BufferedReader(new FileReader(inputFile)))
        {
            // LinkedHashSet ignores duplicates and preserves insertion order.
            Set<String> uniqueLines = new LinkedHashSet<>();
            String line;

            // Reads every line and stores only the first occurrence.
            while((line = inputReader.readLine()) != null)
            {
                uniqueLines.add(line);
            }

            // Writes the unique lines to the output file.
            try(PrintWriter outputWriter = new PrintWriter(outputFile))
            {
                for(String uniqueLine : uniqueLines)
                {
                    outputWriter.println(uniqueLine);
                }
            }
        }
        catch(IOException e)
        {
            System.out.println("File operation failed: " + e.getMessage());
        }
    }

    public static void main(String[] args)
    {
        // Runs approach 1. Replace this call with approach 2 when needed.
        String sampleData = sampleDataPath("file-operations").toString();
        removeDuplicatesUsingFileScan(sampleData + File.separator + "inputDatafile.txt",
            sampleData + File.separator + "outputDatafile.txt");
    }
    
}
