package Interview.ArrayBased;

public class findLongestWordInString {

    public static String longestWordInString(String a)
    {
        // 1. Missing Validation: Handle null or empty input strings safely
        if (a == null || a.trim().isEmpty()) {
        return "";
        }
        String[] data = a.split("[^a-zA-Z0-9]");

        String longestWord = "";

        //iteration for the elements in the array 
            for(int i = 0; i< data.length; i++)
            {
                System.out.println("data in array is: " + data[i]);

                if(data[i].isEmpty())
                    {
                     continue;
                    }

                if(data[i].length() > longestWord.length())
                    {
                        longestWord = data[i];
                    }
                    
            }
        return longestWord;
    }

    public static void main(String[] args) {
        String testString = "Hi I am from Bangalore";
        String longestWord = longestWordInString(testString);
        System.out.println("Longest word in the string: " + longestWord);
    }
    
}
