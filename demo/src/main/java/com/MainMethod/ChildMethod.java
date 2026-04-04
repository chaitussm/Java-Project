package com.MainMethod; 

public class ChildMethod {
    //In Java, the main method can be inherited by subclasses. If a subclass does not define its own main method, it can still be executed using the main method of its superclass. This is because the main method is static and belongs to the class rather than an instance of the class.
    //When a subclass inherits the main method from its superclass, it can be executed as long as the main method in the superclass is accessible (i.e., it is declared as public). The JVM will look for the main method in the subclass first, and if it does not find one, it will look for it in the superclass.
    //This allows for code reuse and allows subclasses to inherit common functionality from their superclasses while still being able to execute their own specific logic if needed.
    
    public void demo() {
        System.out.println("This is the demo method in the ChildMethod class");
    }
}