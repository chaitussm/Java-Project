package Interview.ArrayBased;
import java.util.ArrayList;
import java.util.List;

public class findLongestWordsInString {

     public static void printLongestWords(String a) {
        // Missing Validation: Handle null or empty input strings safely
        if (a == null || a.trim().isEmpty()) {
            System.out.println("Input string is empty.");
            return;
        }

        String[] data = a.split("[^a-zA-Z0-9]+");
        
        String firstLongestWord = "";
        List<String> allLongestWords = new ArrayList<>();
        int maxLength = 0;

        for (int i = 0; i < data.length; i++) {
            String word = data[i];
            if (word.isEmpty()) continue;

            // Option 1 Approach: Found a strictly longer word
            if (word.length() > maxLength) {
                maxLength = word.length();
                firstLongestWord = word;      // Tracks Option 1 (First occurrence)
                
                allLongestWords.clear();     // Clear previous shorter words
                allLongestWords.add(word);   // Start tracking Option 3 ties
            } 
            // Option 3 Approach: Found a tie (same maximum length)
            else if (word.length() == maxLength) {
                allLongestWords.add(word);
            }
        }

        // --- ENHANCED LOGIC SWITCH ---
        // If there are more words with the same maximum length, use Option 3 output
        if (allLongestWords.size() > 1) {
            System.out.println("Multiple longest words found (Option 3): " + allLongestWords);
        } else {
            System.out.println("Single longest word found (Option 1): " + firstLongestWord);
        }
    }

    public static void main(String[] args) {
        // Test Case 1: Multiple words with a tie (Should trigger Option 3)
        System.out.println("--- Test 1 ---");
        printLongestWords("The quick brown fox jumps over the lazy dog");

        // Test Case 2: Only one clear longest word (Should trigger Option 1)
        System.out.println("\n--- Test 2 ---");
        printLongestWords("Hi I am from Bangalore");
    }

}