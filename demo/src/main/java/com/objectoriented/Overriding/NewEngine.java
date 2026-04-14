package com.objectoriented.Overriding;

public class NewEngine extends CarEngine {

    // Overriding the start method of CarEngine class
    @Override
    public int start() {
        int rpm = 1500;
        System.out.println("New engine is starting with more power...");
        return rpm;
    }
    
    public static void main(String[] args) {
        NewEngine newEngine = new NewEngine();
        int rpm = newEngine.start();
        System.out.println("RPM of the new engine: " + rpm);
    }
    
}
