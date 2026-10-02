package com.generics.genericWithitsExtendedClasses;

public class GenericWithStringClasses<T extends String> {
    private T value;

    public GenericWithStringClasses(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "GenericWithStringClasses{" +
                "value=" + value +
                '}';
    }

    public int getLength() {
        return value.length();
    }

    public boolean isEmpty() {
        return value.isEmpty();
    }

    public String toUpperCase() {
        return value.toUpperCase();
    }

    public static void main(String[] args) {
        GenericWithStringClasses<String> example = new GenericWithStringClasses<>("Hello");
        System.out.println(example.getValue());
        System.out.println(example.getLength());
        System.out.println(example.isEmpty());
        System.out.println(example.toUpperCase());
    }
}
