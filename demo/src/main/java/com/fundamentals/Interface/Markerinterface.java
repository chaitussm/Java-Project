package com.fundamentals.Interface;

interface Runnable {
}
public class Markerinterface implements Runnable   {

    // A marker interface in Java is an interface that does not contain any methods or fields. It is used to indicate that a class belongs to a particular category or has a specific property. 
    // Marker interfaces are often used to provide metadata about a class, such as whether it is serializable, cloneable, or comparable. 
    // The presence of a marker interface can be checked at runtime using the instanceof operator or through reflection. 
    // Marker interfaces can be useful for providing additional information about a class without requiring it to implement any specific behavior, but they can also lead to confusion and should be used judiciously.
    
    public static void main(String[] args) {

        Markerinterface obj = new Markerinterface();
        if (obj instanceof Runnable) {
            System.out.println("The object is an instance of the Runnable marker interface.");
        } else {
            System.out.println("The object is not an instance of the Runnable marker interface.");
        }
    }
}
