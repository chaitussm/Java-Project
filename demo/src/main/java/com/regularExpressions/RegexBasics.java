package com.regularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regexBasics {

    public static void fetchPattern(String patternString,String input )
    {
        System.out.println("Fetching pattern for input: " + input);
        
        int count = 0;

        Pattern pattern = Pattern.compile(input);
        
        Matcher matcher = pattern.matcher(patternString);

        while (matcher.find()) {

            System.out.println(matcher.start()+ "===" + matcher.end() + "===" + matcher.group());
            count++;
        }
        System.out.println("Total patterns found: " + count);
    }

    public static void fetchCharacter(String patternString,String input )
    {
        System.out.println("Fetching character for input: " + input);
        
        int count = 0;

        Pattern pattern = Pattern.compile(input);
        
        Matcher matcher = pattern.matcher(patternString);

        while (matcher.find()) {

            System.out.println(matcher.start()+ "===" + matcher.group());
            count++;
        }
        System.out.println("Total patterns found: " + count);
    }
    
}
