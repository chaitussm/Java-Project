package com.javalangPackage.strings.stringConstuctors;

public class stringMethods {

    public static void CaseMethods()
    {
        String s = new String("shiva");
        // Here 2 objects are created in heap and SCP memory and reference variable s will point to the object in heap memory
        String s1 = s.toUpperCase();
         // Here one new object i created in heap memory and reference variable s1 will point to that object
        String s2 = s.toLowerCase();
        // Here no new object will be created as shiva is already present so s2 will point to the existing object in heap memory.
        String s3 = s.toString();
        System.out.println(s == s1);
        System.out.println(s == s2);
        System.out.println(s == s3);

    }

    public static void main(String[] args) {

        // The overloaded + and += operators are used for concatenation of strings.
        String s = new String("Shiva");
        System.out.println("String length: " + s.length());
        System.out.println("Character at index 2: " + s.charAt(2));
        System.out.println("Substring from index 2: " + s.substring(2));
        //In the below example starting index from to n-1 index
        System.out.println("Substring from index 1 to 4: " + s.substring(1, 4));
        System.out.println("Index of character 'v': " + s.indexOf('v'));
        System.out.println("Last index of character 'a': " + s.lastIndexOf('a'));
        CaseMethods();
        System.out.println("Does the string start with 'Sh': " + s.startsWith("Sh"));
        System.out.println("Does the string end with 'va': " + s.endsWith("va"));
        System.out.println("Is the string empty: " + s.isEmpty());
        System.out.println("Equals Method: " + s.equals("Shiva"));
        System.out.println("EqualsIgnoreCase Method: " + s.equalsIgnoreCase("shiva"));
        System.out.println("CompareTo Method: " + s.compareTo("Shiva"));
        System.out.println("CompareToIgnoreCase Method: " + s.compareToIgnoreCase("shiva"));
        System.out.println("Replace Method: " + s.replace('i', 'a'));
        //To remove the blank spaces from the string at beggining and end of the string we can use trim() method
        System.out.println("Trim Method: " + s.trim());

    }
    
}
