package com.Arrays;

public class InitializeArray {
    
    public static void initializeArray()
    {
        // Initializing an array of integers
        int[] numbers = {1, 2, 3, 4, 5};
        
        // Initializing an array of strings
        String[] fruits = {"Apple", "Banana", "Cherry"};
        
        // Initializing an array of doubles
        double[] prices = {9.99, 19.99, 29.99};
        
        // Printing the initialized arrays
        System.out.println("Numbers: ");
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println("\nFruits: ");
        for (String fruit : fruits) {
            System.out.print(fruit + " ");
        }
        System.out.println("\nPrices: ");
        for (double price : prices) {
            System.out.print(price + " ");
        }
    }

    public static void printTypeOFArray()
    {
        int[] a = new int[5];
        System.out.println("Type of array a: " + a.getClass().getName());   

        String[] b = new String[5];
        System.out.println("Type of array b: " + b.getClass().getName());

        double[] c = new double[5];
        System.out.println("Type of array c: " + c.getClass().getName());

        float[] d = new float[5];
        System.out.println("Type of array d: " + d.getClass().getName());

        long[] e = new long[5];
        System.out.println("Type of array e: " + e.getClass().getName());

        char[] f = new char[5];
        System.out.println("Type of array f: " + f.getClass().getName());

        boolean[] g = new boolean[5];
        System.out.println("Type of array g: " + g.getClass().getName());

        short[] h = new short[5];
        System.out.println("Type of array h: " + h.getClass().getName());


    }

    public static void main(String[] args) {
        initializeArray();
        printTypeOFArray();
    }
}
