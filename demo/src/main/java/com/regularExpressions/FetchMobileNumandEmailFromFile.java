package com.regularExpressions;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import com.javaIOPackage.baseMethodsInFileOperations.fileBasicMethods;

public class FetchMobileNumandEmailFromFile extends fileBasicMethods{


    /*
        This class is used to fetch mobile numbers and email addresses from a file.
        Here mobile numbers are mixed with normal data
        We need to fetch the mobiel numbers and emdild from the given file and then 
        we need to stor in the ouput file 
    */

    public static Map<String, Set<String>> fetchMobileNumandEmailFromFile(String inputFilePath, String outputFilePath) {
        // Implementation to fetch mobile numbers and email addresses from the input file
        // and store them in the output file

       Map<String, Set<String>> extractedData = new LinkedHashMap<>();
       extractedData.put("Mobile", new LinkedHashSet<>());
       extractedData.put("Email", new LinkedHashSet<>());

       try(PrintWriter writer = new PrintWriter(outputFilePath);
           BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
           // Implementation to write fetched mobile numbers and email addresses to the output file
           String regxMobileNumber = "(0|91)?[7-9][0-9]{9}";
           Pattern mobilePattern = Pattern.compile(regxMobileNumber);
           String regxEmail = "[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+";
           Pattern emailPattern = Pattern.compile(regxEmail);

           String line;
           while ((line = reader.readLine()) != null) {
               java.util.regex.Matcher mobileMatcher = mobilePattern.matcher(line);
               while (mobileMatcher.find()) {
                   extractedData.get("Mobile").add(mobileMatcher.group());
               }
               java.util.regex.Matcher emailMatcher = emailPattern.matcher(line);
               while (emailMatcher.find()) {
                   extractedData.get("Email").add(emailMatcher.group());
               }
           }

           for (String mobileNumber : extractedData.get("Mobile")) {
               writer.println("Mobile: " + mobileNumber);
           }
           for (String emailAddress : extractedData.get("Email")) {
               writer.println("Email: " + emailAddress);
           }
       } catch (IOException e) {
           e.printStackTrace();
       }

       return extractedData;
    }

    public static void main(String[] args) {
        String inputFilePath = sampleDataPath("file-operations", "fetchdata.txt").toString();
        String outputFilePath = sampleDataPath("file-operations", "writeFetchedData.txt").toString();
        Map<String, Set<String>> extractedData = fetchMobileNumandEmailFromFile(inputFilePath, outputFilePath);
        System.out.println("Extracted Data: " + extractedData);
    }
    
}
