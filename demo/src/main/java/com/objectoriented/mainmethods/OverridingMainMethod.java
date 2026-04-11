package com.objectoriented.mainmethods;

public class OverridingMainMethod extends ChildMethod{
    
    //In Java, the main method can be overridden in a subclass. However, it is important to note that the main method is static, and static methods cannot be overridden in the traditional sense. Instead, when a subclass defines a main method with the same signature as the main method in its superclass, it is considered to be hiding the superclass's main method rather than overriding it.
    //When the JVM looks for the main method to execute, it will first look for it in the subclass. If it finds a main method there, it will execute that one instead of the main method in the superclass. This means
    //that if you run the subclass, it will execute the main method defined in the subclass, and if you run the superclass, it will execute the main method defined in the superclass.
    //This allows for different entry points for different classes in the inheritance hierarchy, but it is
    // For main method instead of oeverrding method hiding will happens 

    public static void main(String[] args) {
        System.out.println("This is the main method in the OverridingMainMethod class");

        //Calling the demo method from the ChildMethod class
        OverridingMainMethod obj = new OverridingMainMethod();
        obj.demo();

        //Here mthod hiding happens not method overriding 
    }



}
    