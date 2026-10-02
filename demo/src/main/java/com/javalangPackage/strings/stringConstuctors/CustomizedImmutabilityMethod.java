package com.javalangPackage.strings.stringConstuctors;

public class CustomizedImmutabilityMethod {

    private int i;

    public CustomizedImmutabilityMethod(int i) {
        this.i = i;
    }

    public CustomizedImmutabilityMethod modify(int i) {
        if (this.i == i) {
            return this;
        } else {
            return new CustomizedImmutabilityMethod(i);
        }
    }

    public static void main(String[] args) {
        CustomizedImmutabilityMethod obj1 = new CustomizedImmutabilityMethod(10);
        CustomizedImmutabilityMethod obj2 = obj1.modify(100);
        CustomizedImmutabilityMethod obj3 = obj1.modify(10);

        System.out.println("obj1: " + obj1);
        System.out.println("obj2: " + obj2);
        System.out.println("obj3: " + obj3);

        System.out.println("obj1 == obj2: " + (obj1 == obj2));
        System.out.println("obj1 == obj3: " + (obj1 == obj3));

        System.out.println("obj1 hashcode: " + obj1.hashCode());
        System.out.println("obj2 hashcode: " + obj2.hashCode());
        System.out.println("obj3 hashcode: " + obj3.hashCode());

    }
    
}
