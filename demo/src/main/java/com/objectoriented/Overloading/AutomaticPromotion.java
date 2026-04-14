package com.objectoriented.Overloading;

public class AutomaticPromotion {

    // Method to demonstrate automatic promotion
    public void display(int a) {
        System.out.println("Integer value: " + a);
    }

    public void display(double a) {
        System.out.println("Double value: " + a);
    }

    public static void main(String[] args) {
        AutomaticPromotion ap = new AutomaticPromotion();
        
        // Automatic promotion from int to double
        ap.display(10); // This will call the display(int a) method
        ap.display('A'); // This will call the display(int a ) method
        //Here automatic promotion happens from char to int because char is a 16-bit Unicode character and it can be promoted to an int which is a 32-bit signed integer. The ASCII value of 'A' is 65, so when we pass 'A' to the display method, it gets promoted to the integer value 65 and calls the display(int a) method.
        ap.display(3.14); // This will call the display(double a) method
    }
    
}
