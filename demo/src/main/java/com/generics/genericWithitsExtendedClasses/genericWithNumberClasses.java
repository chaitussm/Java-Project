package com.generics.genericWithitsExtendedClasses;

public class genericWithNumberClasses<T extends Number> {

    private T value;

    public genericWithNumberClasses(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void printGenericClass() {
        System.out.println("Generic Class is: " + value.getClass().getName());
    }

    public void printValueTimesTwo() {

        System.out.println("Value times two is: " + (value.doubleValue() * 2));
    }

    public static void main(String[] args) {
        genericWithNumberClasses<Integer> example = new genericWithNumberClasses<>(5);
        example.printGenericClass();
        example.printValueTimesTwo();
        // if we take String it will give a compile-time error saying
        // "Type parameter 'T' is not within its bound; should extend 'Number'"
        // because T is bounded by Number
    }
}
