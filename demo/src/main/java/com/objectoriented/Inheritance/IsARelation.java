package com.objectoriented.Inheritance;


public class IsARelation extends BaseClass {

    public void data() {
        System.out.println("This is the IS-A relation in Java, which is called inheritance.");
    }

    //IS-A relation is called as inheritancve in java 
    // If one class acquires the properties and behaviors of another class, it is called inheritance. The class that inherits the properties and behaviors is called the subclass or child class, and the class from which it inherits is called the superclass or parent class.
    // Inheritance allows for code reusability and promotes a hierarchical classification of classes. It enables the creation of new classes based on existing classes, which can help to reduce code duplication and improve maintainability.
    // In Java, inheritance is achieved using the "extends" keyword. A subclass
   // can override the methods of the superclass to provide its own implementation, and it can also add new methods and fields to enhance its functionality. 
    // The IS-A relationship is a fundamental concept in object-oriented programming and is used to model real-world relationships between objects.
    
    public static void main(String[] args) {
        System.out.println("IS-A relation in Java is called inheritance.");

        IsARelation obj = new IsARelation();
        obj.display();
        obj.data();

        // with child class reference we can access the method of parent class and child class because child class is inheriting the properties and behaviors of parent class but with parent class reference we can only access the method of parent class because parent class is not inheriting the properties and behaviors of child class.
        BaseClass obj1 = new IsARelation();
        obj1.display();

        BaseClass obj2 = new IsARelation();
        obj2.display();   // This will cause a compile-time error because the reference type is Base

        //IsARelation obj3 = new BaseClass();  // child class object reference cannot hold parent class object
        // This will cause a compile-time error because the reference type is IsARelation
       // obj3.display();
    }
    
}
