package com.fundamentals.operators;

public class EqualityOperators {

    //Understand the concept of equality operators in Java
    //Equality operators are used to compare two values for equality or inequality. They return a boolean result (true or false) based on the comparison.
    //The equality operators in Java are:
    //1. Equal to (==): Returns true if the operands are equal
    //2. Not equal to (!=): Returns true if the operands are not equal

    public static void main(String[] args) {
        int a = 10;
        int b = 5;

        System.out.println("a == b: " + (a == b)); // Output: false
        System.out.println("a != b: " + (a != b)); // Output: true

        String str1 = "Hello";
        String str2 = "Hello";
        String str3 = new String("Hello");
        
     
        System.out.println("str1 == str2: " + (str1 == str2)); 
        //In the above example result is true because str1 and str2 referencing same literals in the string pool, so they point to the same memory location. 
        System.out.println("str1 == str3: " + (str1 == str3)); 
        // Output: false (because str3 is a new object)
        // new String("Hello") creates a new String object in memory i.e String constant pool , so str3 references a different memory location than str1, even though they have the same content. Therefore, 
        // the == operator returns false when comparing str1 and str3.
        System.out.println("str1.equals(str3): " + str1.equals(str3)); // Output: true (because equals() compares content)
        // In the above example result is true because the equals() method compares the content of the strings, 
        // and str1 and str3 have the same content ("Hello"), so it returns true.
        // Important points to remember:
        // 1. The == operator compares the references of objects, not their content. For primitive data types, it compares their values.
        // 2. The equals() method should be used to compare the content of objects, especially for strings and other complex data types.
        // 3. null == null is true because both sides are null, but null.equals(null) will throw a NullPointerException because you cannot call a method on a null reference. Always check for null before using the equals() method to avoid this exception.
    }
    
}
