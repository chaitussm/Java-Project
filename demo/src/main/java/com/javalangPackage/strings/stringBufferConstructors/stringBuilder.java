package com.javalangPackage.strings.stringBufferConstructors;

public class stringBuilder {

    /*
     *
     * StringBuilder class is used to create mutable string object
     * StringBuilder class is same as StringBuffer class except that StringBuilder is non-synchronized
     * StringBuilder class is faster than StringBuffer class because of non-synchronization
     * StringBuilder class is introduced in Java 5 version
     * StringBuilder class is used in single-threaded environment
     * StringBuffer class is used in multi-threaded environment
     * StringBUilder is thread unsafe whereas StringBuffer is thread safe
     * StringBuilder class is used to create mutable string object
     * StringBuilder class is same as StringBuffer class except that StringBuilder is non-synchronized
     * StringBuilder class is faster than StringBuffer class because of non-synchronization
     * StringBuilder class is introduced in Java 5 version
     * StringBuilder class is used in single-threaded environment
     * StringBuffer class is used in multi-threaded environment
     * StringBUilder is thread unsafe whereas StringBuffer is thread safe
     * StringBuilder class is used to create mutable string object
     */

    public static void main(String[] args)
    {
        StringBuilder sb = new StringBuilder("Shiva");
        System.out.println(sb);
        System.out.println(sb.length());
        System.out.println(sb.capacity());
        sb.append(" Parvathi");
        System.out.println(sb);
        System.out.println(sb.length());
        System.out.println(sb.capacity());
    }
    
}
