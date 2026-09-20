package com.generics.genericMethods;

import java.util.ArrayList;

public class sendingGenericToNonGenericArea {

    public static void main(String[] args) {
       
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("Hello");
        stringList.add("World");
        //stringList.add(10); // This would cause a compile-time error because stringList is of type ArrayList<String>

        sendToNonGenericArea(stringList);

        System.out.println("After sending to non-generic area: " + stringList);
    }

   public static void sendToNonGenericArea(ArrayList stringList) {
        
        stringList.add(10);
        stringList.add(10.5);
    }


    
}
