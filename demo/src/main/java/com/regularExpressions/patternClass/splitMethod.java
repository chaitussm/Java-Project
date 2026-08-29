package com.regularExpressions.patternClass;
import java.util.regex.Pattern;
public class splitMethod {

    public static void splitToPatternString(String input , String data) {

        Pattern pattern = Pattern.compile(input); // example pattern to split by whitespace
        String[] result = pattern.split(data); 
        for (String str : result) {
            System.out.println(str);
        }
    }

    public static void main(String[] args) {
        String input = "This is an example string";
        splitToPatternString("\\s+", input);
        String input2 = "www.durgajobs.com";
        splitToPatternString("[.]", input2);
    }
}
