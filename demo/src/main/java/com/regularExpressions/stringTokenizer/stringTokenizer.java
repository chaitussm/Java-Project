package com.regularExpressions.stringTokenizer;

import java.util.StringTokenizer;

public class stringTokenizer {

    public static void tokenizeString(String input) {
        StringTokenizer tokenizer = new StringTokenizer(input);
        while (tokenizer.hasMoreTokens()) {
            System.out.println(tokenizer.nextToken());
        }
    }

    public static void tokenizeString(String input, String delimiter) {
        StringTokenizer tokenizer = new StringTokenizer(input, delimiter);
        while (tokenizer.hasMoreTokens()) {
            System.out.println(tokenizer.nextToken());
        }
    }

    public static void main(String[] args) {
        String input = "This is an example string";
        tokenizeString(input);
        System.out.println("Using custom delimiter:");
        String input1 = "19-09-2015";
        tokenizeString(input1, "-");
    }
}
