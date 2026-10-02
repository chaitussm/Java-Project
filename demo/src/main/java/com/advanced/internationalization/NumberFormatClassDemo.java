package com.advanced.internationalization;

import java.text.NumberFormat;

public class numberFormatClassDemo {

    public static void printNumberFormat() {
        java.text.NumberFormat numberFormat = java.text.NumberFormat.getInstance();
        System.out.println(numberFormat.format(1234567.89));
    }

    public static void printCurrencyFormat() {
        java.text.NumberFormat currencyFormat = java.text.NumberFormat.getCurrencyInstance();
        System.out.println(currencyFormat.format(1234567.89));
    }

    public static void printPercentFormat() {
        java.text.NumberFormat percentFormat = java.text.NumberFormat.getPercentInstance();
        System.out.println(percentFormat.format(0.89));
    }

    public static void printIntegerFormat() {
        java.text.NumberFormat integerFormat = java.text.NumberFormat.getIntegerInstance();
        System.out.println(integerFormat.format(1234567.89));
    }

    public static void getCountrySpecificCurrencyFormat() {
        NumberFormat usCurrencyFormat = java.text.NumberFormat.getCurrencyInstance(java.util.Locale.US);
        NumberFormat ukCurrencyFormat = java.text.NumberFormat.getCurrencyInstance(java.util.Locale.UK);
        NumberFormat indiaCurrencyFormat = java.text.NumberFormat.getCurrencyInstance(new java.util.Locale("en", "IN"));

        System.out.println("US: " + usCurrencyFormat.format(1234567.89));
        System.out.println("UK: " + ukCurrencyFormat.format(1234567.89));
        System.out.println("India: " + indiaCurrencyFormat.format(1234567.89));
    }

    public static void getCountrySpecificNumberFormat() {
       
        java.util.Locale india = new java.util.Locale("en", "IN");

        NumberFormat nf = NumberFormat.getNumberInstance(india);

        System.out.println(nf.format(1234567.89));

    }

    public static void setMaximumFractionDigits(int digits) {
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(digits);
        System.out.println("maximum " + digits + " fraction digits: " + numberFormat.format(1234567.891234));
    }

    public static void setMinimumFractionDigits(int digits) {
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMinimumFractionDigits(digits);
        System.out.println("minimum " + digits + " fraction digits: " + numberFormat.format(1234567.8));
    }

    public static void main(String[] args) {
        printNumberFormat();
        printCurrencyFormat();
        printPercentFormat();
        printIntegerFormat();
        getCountrySpecificCurrencyFormat();
        getCountrySpecificNumberFormat();
        setMaximumFractionDigits(3);
        setMinimumFractionDigits(3);
    }
    
}
