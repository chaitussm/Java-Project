package com.javalangPackage.strings.stringConstuctors;

public class stringconstructor {

    public static void main(String[] args) {
        String s = new String();
        System.out.println("String object created using default constructor: " + s);
        //Above statement creates an empty string object in the heap memory and the reference variable s will point to that object
        String s1 = new String("Shiva");
        System.out.println("String object created using parameterized constructor: " + s1);
        char[] ch = {'S', 'h', 'i', 'v', 'a'};
        String s2 = new String(ch);
        System.out.println("String object created using char array constructor: " + s2);
        byte[] b = {65, 66, 67, 68, 69};
        String s3 = new String(b);
        System.out.println("String object created using byte array constructor: " + s3);
        //Above examples creates a String Object in the heap memory and the reference variable will point to that object for the given
        //String literal, char array and byte array respectively.
        StringBuffer sb = new StringBuffer("Shiva");
        String s4 = new String(sb);
        //creates an equivalent String object for the String buffer
    }
    
}