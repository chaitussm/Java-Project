package com.regularExpressions.patternClass;
import java.util.regex.Pattern;
public class splitMethod {

    /**
     * String class also contains to split the target String according to a particular pattern 
     *
     * @param input the regex pattern to split by
     * @param data the string to be split
     *
     */

    public static void splitwithPatternClass(String input , String data) {

        Pattern pattern = Pattern.compile(input); // example pattern to split by whitespace
        String[] result = pattern.split(data); 
        for (String str : result) {
            System.out.println(str);
        }
    } 

    public static void splitwithStringClass(String input) {

        String[] result = input.split(" "); // example split by whitespace
        for (String str : result) {
            System.out.println("With String class Split Method " + str);
        }
    } 



    public static void main(String[] args) {
        String input = "This is an example string";
        splitwithPatternClass("\\s+", input);
        splitwithStringClass(input);
        String input2 = "www.durgajobs.com";
        splitwithPatternClass("[.]", input2);
        splitwithStringClass(input2);
    }
}
