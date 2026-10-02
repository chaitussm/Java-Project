package com.generics.wildCardCharacter;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class exampleOne {

    public static void main(String[] args) {
        
        ArrayList<Runnable> runnableList = new ArrayList<Runnable>();//valid for Runnable objects
        //ArrayList<?> ob = new ArrayList<?>() invalid as we need to specify a concrete type for instantiation
        ArrayList<? extends Number> numberList = new ArrayList<Integer>();//valid as Integer extends Number
        //ArrayList<? super String> superNumberList = new ArrayList<Number>();//invalid as Number is not a super type of String
        ArrayList<? super String> superStringList = new ArrayList<Object>();//valid as Object is a super type of String

    }
    
}
