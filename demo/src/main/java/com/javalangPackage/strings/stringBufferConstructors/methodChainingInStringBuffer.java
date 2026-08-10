package com.javalangPackage.strings.stringBufferConstructors;

public class methodChainingInStringBuffer {

     /*
      * Method Chaining in StringBuffer
      * For most of the methods in string, StringBuffer and stringBuilder return types are same type hence after applying a method on the 
      * result we can call another method whic forms method chaining, in method chaining methods calles will be executed 
      * from left to right 
      */

     public static void main(String[] args)
     {
        StringBuffer sb = new StringBuffer("Shiva");
        sb.append(" Namah").append("Parvathy").append(" Pathaye Har Har Mahadev");
        System.out.println(sb);
        System.out.println(sb.length());
        System.out.println(sb.capacity());
     }
    
}
