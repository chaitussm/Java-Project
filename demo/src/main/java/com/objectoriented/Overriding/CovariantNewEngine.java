package com.objectoriented.Overriding;

public class CovariantNewEngine extends CovariantEngine {

    // In covariant return type, the return type of the overridden method in the subclass can be a subtype of the return type declared in the superclass method. This allows for more specific return types in the subclass while still maintaining compatibility with the superclass method.
    // Overriding the start method of CarEngine class with a covariant return type
    @Override
    public Integer start() {
        System.out.println("Covariant engine is starting...");
        return 2000; // Returning an Integer, which is a subclass of Number
    }
    
    public static void main(String[] args) {
        CovariantEngine covariantEngine = new CovariantEngine();
       
        System.out.println("RPM of the new engine: " +  covariantEngine.start());
    }
    
}
