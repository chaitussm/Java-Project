package com.javaIOPackage.mergeFiles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import com.javaIOPackage.baseMethodsInFileOperations.fileBasicMethods;

public class fileMergerwithLineByLine extends fileBasicMethods {

    public static void mergeFiles(String finalfile, String firstfile, String secondfile) throws IOException {
        
        // Open all 3 resources safely. Separated by semicolons.
        try (PrintWriter pw = new PrintWriter(finalfile);
             BufferedReader br1 = new BufferedReader(new FileReader(firstfile));
             BufferedReader br2 = new BufferedReader(new FileReader(secondfile))) {

             String firstfiledata = br1.readLine();
             String secondfiledata = br2.readLine();
            
            while(firstfiledata!= null || secondfiledata!= null)
            {
                if(firstfiledata!=null)
                {
                    pw.println(firstfiledata);
                    firstfiledata = br1.readLine();
                }
                if(secondfiledata!=null)
                {
                    pw.println(secondfiledata);
                    secondfiledata = br2.readLine();
                }
            }
            
        } // All 3 streams are guaranteed to close safely here, even if an error occurs!
    }

    public static void main(String[] args) throws Exception
    {
        mergeFiles(sampleDataPath("file-operations", "mergedFileOne.txt").toString(),
            sampleDataPath("file-operations", "BufferedData.txt").toString(),
            sampleDataPath("file-operations", "enhancedWriter.txt").toString());
    }
    
}
