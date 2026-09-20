package com.generics.ourOwnGenericClasses;

public class genericBase<T> {
    private T value;

    public genericBase(T value) {
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

}
