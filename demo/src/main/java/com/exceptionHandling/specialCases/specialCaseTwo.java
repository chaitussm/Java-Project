package com.exceptionHandling.specialCases;

public class specialCaseTwo {

    public static void main(String[] args) {

        /*In this we  wont get any compile tiem errors beacuse of Exception is partially checkd exception */

        try{

            System.out.println("Partially checked exception");
        }

        catch (Exception e){

            System.out.println("Exception occured");
        }
    }
    
}
