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
        
        String regxMobileNumber = "(0|91)?[7-9][0-9]{9}";
        Pattern pattern = Pattern.compile(regxMobileNumber);
        Matcher matcher = pattern.matcher(args[0]);
        if (matcher.find() && matcher.group().equals(args[0])) {
            System.out.println("Valid mobile number");
        } else {
            System.out.println("Invalid mobile number");
        }
    }

    public static void checkEmail(String[] args) {

        if (args.length == 0) {
            System.out.println("Usage: pass an email address as a command-line argument");
            return;
        }
        String regxEmail = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(regxEmail);
        Matcher matcher = pattern.matcher(args[0]);
        if (matcher.find() && matcher.group().equals(args[0])) {
            System.out.println("Valid email address");
        } else {
            System.out.println("Invalid email address");
        }
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: checkNumber <mobile|email> <value>");
            return;
        }

        String[] value = {args[1]};
        if (args[0].equals("mobile")) {
            checkMobileNumber(value);
        } else if (args[0].equals("email")) {
            checkEmail(value);
        } else {
            System.out.println("Type must be either mobile or email");
        }
    }
    
}
