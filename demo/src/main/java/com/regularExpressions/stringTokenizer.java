package com.regularExpressions;

import java.util.StringTokenizer;

public class stringTokenizer {

    public static void tokenizeString(String input) {
        StringTokenizer tokenizer = new StringTokenizer(input);
        while (tokenizer.hasMoreTokens()) {
            System.out.println(tokenizer.nextToken());
        }
    }

    public static void main(String[] args) {
        String input = "This is an example string";
        tokenizeString(input);
    }
}
