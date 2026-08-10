package com.javalangPackage.strings.stringBufferConstructors;


import java.io.ObjectStreamClass;
import java.lang.reflect.Method;

public class stringBuffer {

    /*
     * If the content is fixed and wont change ferquenntly then it is recommended to use String class 
     * If the content is not fixed and will change frequently then it is recommended to use StringBuffer class 
     * because StringBuffer class is mutable and hence it is more efficient than String class
     * All required changes in StringBuffer will be performed in the existing object only 
     * at line no 15 creates an empty String buffer Object with default capacity of 16 characters
     * Once stringBuffer reaches to its max capacity a new stringBuffer object will be created 
     * new capactiy = (current capacity +1)*2 
     * Every method present in the stringBuffer is synchronized and hence only one thread is allowed to operate on stringBuffer at a time.
     */
    public static void methodInClasses(StringBuffer o)
    {
        Class<?> cs = o.getClass();

        Method[] m = cs.getDeclaredMethods();
        
        int count = 0;

        for(Method m1 : m)
        {
            count++;
            System.out.println(m1.getName());
        }

        System.out.println("Total number of methods in " + cs.getName() + " class: " + count);
    }
    public static void stringBufferConstructors()
    {
        StringBuffer sb = new StringBuffer();

        methodInClasses(sb);

        StringBuffer sb1 = new StringBuffer(20); 
        // creates any stringBuffer object with initial capacity of 20 characters with specified initial capacity

        StringBuffer sb2 = new StringBuffer("Namah Parvathy Pathaye");// Here capacity is string length + 16 = 22 + 16 = 37
        System.out.println("StringBuffer object with current capacity is: " + sb2.capacity());
        // for the given string equivalence stringBuffer object will be created with initial capacity of 16 + length of the given string
    }

    public static void stringBufferMethods()
    {
        StringBuffer sb = new StringBuffer("Namah Parvathy Pathaye");
        System.out.println("StringBuffer object with current capacity is: " + sb.capacity());
        System.out.println("StringBuffer object with current length is: " + sb.length());
        sb.append("Har Har Mahadev");
        sb.append(true);
        // for any type of datatype append is applicable all these methods are overloaded methods
        System.out.println("StringBuffer object after appending another string: " + sb.capacity());
        System.out.println("StringBuffer object after getting length of another string: " + sb.length());
        System.out.println("StringBuffer object after getting character at index 2: " + sb.charAt(2));
        System.out.println("StringBuffer object after searching for index another string: " + sb.indexOf("Parvathy"));
        System.out.println("StringBuffer object after searching for last index another string: " + sb.lastIndexOf("a"));
        System.out.println("StringBuffer object after searching for substring another string: " +sb.substring(6, 14));
        System.out.println("StringBuffer object after reversing string: " + sb.reverse());
        System.out.println("StringBuffer object after deleting another string: " + sb.delete(0, 6));   
        System.out.println("StringBuffer object after deleting a character: " + sb.deleteCharAt(0));
        System.out.println("StringBuffer object after inserting another string: " + sb.insert(0, "Har Har Mahadev "));
        System.out.println("StringBuffer object after replacing another string: " + sb.replace(0, 3, "Om"));
        System.out.println("StringBuffer object after appending another string: " + sb.reverse());
        sb.setLength(10);
        System.out.println("StringBuffer object after setting length: " + sb.length());
        //on demand and on fly where I want to oncrese the capacity based on the requirement we can use ensureCapacity() method
        sb.ensureCapacity(500);
        System.out.println("StringBuffer object after ensuring capacity: " + sb.capacity());
        //to delallocate the extra memory we can use trimToSize() method
        sb.trimToSize();
        System.out.println("StringBuffer object after trimming capacity: " + sb.capacity());
    
    }
    public static void main(String[] args)
    {
        StringBuffer sb = new StringBuffer();
        System.out.println("StringBuffer object with default capacity: " + sb.capacity());
        sb.append("Namah Parvathy Pathaye");
        System.out.println("StringBuffer object after appending string: " + sb.capacity());
        sb.append("Har Har Mahadev");
        System.out.println("StringBuffer object after appending another string: " + sb.capacity());
        stringBufferConstructors();
        stringBufferMethods();
    }
    
}
