package com.generics.validationForGenericsonlyAtCompiletime;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class validationDemo {

    //Proof 1: Bypassing Generics at Runtime via Reflection
    public static void bypassGenericsWithReflection() throws NoSuchMethodException, IllegalAccessException, java.lang.reflect.InvocationTargetException {
       

         // Nested block to demonstrate reflection bypassing generics
        // Proof 1: Bypassing Generics at Runtime via Reflection
         // 1. Create a List strictly typed for Strings
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("Hello");
        
        // This would fail at COMPILE TIME:
        // stringList.add(100); 

        // 2. Fetch the 'add' method at RUNTIME using reflection
        Method addMethod = stringList.getClass().getMethod("add", Object.class);

        // 3. Invoke the method at runtime to inject an Integer
        addMethod.invoke(stringList, 100); 

        // 4. Print the list contents
        System.out.println("List contents: " + stringList);
    }

    //Proof 2: Both Instances Share the Exact Same Class
    public static void bypassGenericsWithClassComparison()
    {
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        // Check if their runtime classes are identical
        System.out.println(list1.getClass() == list2.getClass());
        
        // Print the actual class name at runtime
        System.out.println("list1 class: " + list1.getClass().getName());
        System.out.println("list2 class: " + list2.getClass().getName());
    }
  
   
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, java.lang.reflect.InvocationTargetException {
        bypassGenericsWithReflection();
        bypassGenericsWithClassComparison();
    }

    
}
