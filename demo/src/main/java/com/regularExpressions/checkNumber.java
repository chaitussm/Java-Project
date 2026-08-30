package com.regularExpressions;

import java.util.regex.*;
/**
 * This class is used to check if a given number is a valid mobile number.
 * Rules for a valid mobile number:
 * 1. Should contain exactly 10 digits.
 * 2. The first digit should be 7, 8, or 9.
 * Example: [7-9][0-9]{9}
 * Detailed local and CI execution guide:
 * docs/concepts/RegularExpressions/RegularExpression.md
 */

public class checkNumber {

    public static void checkMobileNumber(String[] args) {

        if (args.length == 0) {
            System.out.println("Usage: pass a mobile number as a command-line argument");
            return;
        }

        Pattern pattern = Pattern.compile("(0|91)?[7-9][0-9]{9}");
        Matcher matcher = pattern.matcher(args[0]);
        if (matcher.find() && matcher.group().equals(args[0])) {
            System.out.println("Valid mobile number");
        } else {
            System.out.println("Invalid mobile number");
        }
    }

    public static void main(String[] args) {
        checkMobileNumber(args);
    }
    
}
