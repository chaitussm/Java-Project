package com.exceptionHandling;

public class typeOfExceptions {

   


    public static void main(String[] args) {
         /*ArrayIndexOutOfBoundsException It is an unchcked exception below example*/
        int arr[] = new int[5];
        System.out.println(arr[10]);
        /*ClassCastException It is an unchcked exception below example*/
        Object obj = "Hello";
        Integer num = (Integer) obj; // This will throw ClassCastException
        /*StackOverflowError It is an unchcked exception below example*/
        //main(args); 
        /*NoclassDefFoundError It is an unchcked exception below example*/
        //Class.forName("NonExistentClass");
        /*ExceptionInInitializerError It is an unchcked exception below example*/
        //int x = 10/0;
        /*IllegalArgumentException It is an unchcked exception below example*/
        //int y = Math.max(-1, 5);
        /*NumberFormatException It is an unchcked exception below example*/
        //int z = Integer.parseInt("abc");

    }
    
}
