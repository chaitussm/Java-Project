package com.objectoriented.Encapsulation;

public class EncapsulationDef {

    // Encapsulation is one of the fundamental principles of object-oriented programming (OOP) that focuses on bundling data (variables) and methods (functions) that operate on the data into a single unit called a class. It also restricts direct access to some of the object's components, which is a means of preventing accidental interference and misuse of the data.

    // In Java, encapsulation is achieved through the use of access modifiers (private, protected, public) to control the visibility of class members. The most common practice is to declare class variables as private and provide public getter and setter methods to access and modify the values of those variables.

    // The benefits of encapsulation include:
    // 1. Data Hiding: Encapsulation allows you to hide the internal state of an object from the outside world, which helps in protecting the integrity of the data.
    // 2. Modularity: Encapsulation promotes modular design by keeping related data and methods together in a single class, making it easier to manage and maintain code.
    // 3. Flexibility: Encapsulation allows you to change the implementation details of a class without affecting other parts of the code that use the class, as long as

    //    the public interface remains unchanged.
    // 4. Improved Security: By controlling access to the data, encapsulation can help prevent unauthorized access and modification, enhancing the security of the application. 


    private String name; // Private variable, cannot be accessed directly from outside the class

    // Public getter method to access the private variable
    public String getName() {
        return name;                            

    }

    // Public setter method to modify the private variable
    public void setName(String name) {
        this.name = name;   
    }

    public static void main(String[] args) {
        EncapsulationDef obj = new EncapsulationDef();
        obj.setName("Encapsulation in Java");
        System.out.println("Name: " + obj.getName());
    }
    
}
