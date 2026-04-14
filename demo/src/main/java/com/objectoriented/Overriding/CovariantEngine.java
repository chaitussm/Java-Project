package com.objectoriented.Overriding;

import java.lang.Number;

public class CovariantEngine {

    // Overriding the start method of CarEngine class with a covariant return type
    public Number start() {
        System.out.println("Covariant engine is starting...");
        return 2000; // Returning an Integer, which is a subclass of Number
    }

    
}
