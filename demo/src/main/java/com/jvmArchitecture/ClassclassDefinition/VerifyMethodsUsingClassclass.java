package com.jvmArchitecture.ClassclassDefinition;

import java.lang.reflect.Method;

public class VerifyMethodsUsingClassclass {

    public static void classClassDemo(String className) 
    {
         int count = 0;

         try {
             Class<?> classType = Class.forName(className);
             Method[] method = classType.getDeclaredMethods();
             for (Method m : method) {
                 count++;
                 System.out.println(m.getName());
             }  
             
            System.out.println("Total methods: " + count);
         } catch (ClassNotFoundException e) {
             e.printStackTrace();
         }
    }

    public static void main(String[] args) {
       
       System.out.println("Methods of com.jvmArchitecture.ClassclassDefinition.TestClass:");
       classClassDemo("com.jvmArchitecture.ClassclassDefinition.TestClass");
       System.out.println("Methods of java.lang.String:");
       classClassDemo("java.lang.String");
    }
    
}
