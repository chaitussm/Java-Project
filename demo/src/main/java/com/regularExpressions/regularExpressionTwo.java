package com.regularExpressions;

public class regularExpressionTwo extends regexBasics{

    public static void main(String[] args) {
        String patternString = "he!0 wor1$";
        String input = "[^a-zA-Z0-9]";
        String input1 = "[a-zA-Z0-9]";
        String input2 = "\\s"; // matches any whitespace character
        
        fetchCharacter(patternString, input);
        fetchCharacter(patternString, input1);
        fetchCharacter(patternString, input2);

        String patternString1 = "We1com& t0 jav@";

        String input3 = "\\d"; // matches any digit
        String input4 = "\\D"; // matches any non-digit character
        String input5 = "\\w"; // matches any word character (alphanumeric + underscore)
        String input6 = "\\W"; // matches any non-word character
        fetchCharacter(patternString1, input3);
        fetchCharacter(patternString1, input4);
        fetchCharacter(patternString1, input5);
        fetchCharacter(patternString1, input6);

        String input7 = "a+"; // matches one or more occurrences of the character 'a'
        fetchCharacter(patternString1, input7);
        
        String input8 = "a*"; // matches zero or more occurrences of the character 'a'
        fetchCharacter(patternString1, input8);
    }
    
}
