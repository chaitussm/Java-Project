package com.advanced.internationalization;

import java.util.Date;
import java.text.DateFormat;
import java.util.Locale;

public class dateFormatClassDemo {

    public static void printDateFormat() {
       DateFormat dateFormat = DateFormat.getDateInstance();
        System.out.println(dateFormat.format(new Date()));
    }

    public static void printTimeFormat() {
        DateFormat timeFormat = DateFormat.getTimeInstance();
        System.out.println(timeFormat.format(new Date()));
    }

    public static void printDateTimeFormat() {
        DateFormat dateTimeFormat = DateFormat.getDateTimeInstance();
        System.out.println(dateTimeFormat.format(new Date()));
    }

    public static void printdaysFormat() {
        DateFormat daysFormat = DateFormat.getDateInstance(DateFormat.FULL);
        System.out.println(daysFormat.format(new Date()));
    }

    public static void printVariousFormsOfdateFormat()
    {
       //print full format of date
       DateFormat fullDateFormat = DateFormat.getDateInstance(DateFormat.FULL);
       System.out.println("Full form: " + fullDateFormat.format(new Date()));
       
       //print long format of date
       DateFormat longDateFormat = DateFormat.getDateInstance(DateFormat.LONG);
       System.out.println("Long form: " + longDateFormat.format(new Date()));

       //print medium format of date
       DateFormat mediumDateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
       System.out.println("Medium form: " + mediumDateFormat.format(new Date()));

       //print short format of date
       DateFormat shortDateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
       System.out.println("Short form: " + shortDateFormat.format(new Date()));

    }

    public static void converStringToJavaDateForm(String dateString) {
        try {
            DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT, Locale.getDefault());
            Date date = dateFormat.parse(dateString);
            System.out.println("Converted date: " + date);
        } catch (Exception e) {
            System.out.println("Error parsing date: " + e.getMessage());
        }
    }

    public static void converLocaleToStringForm(Date date) {
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT, Locale.getDefault());
        String dateString = dateFormat.format(date);
        System.out.println("Converted string: " + dateString);
    }

    public static void main(String[] args) {
        printDateFormat();
        printTimeFormat();
        printDateTimeFormat();
        printdaysFormat();
        printVariousFormsOfdateFormat();
        converStringToJavaDateForm("2024-06-15");
        converLocaleToStringForm(new Date());
    }
    
}
