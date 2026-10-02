package com.generics.genericWithitsExtendedClasses;

public class genericWithStringClasses<T extends String> {
    private T value;

    public genericWithStringClasses(T value) {
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
        return "genericWithStringClasses{" +
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
        genericWithStringClasses<String> example = new genericWithStringClasses<>("Hello");
        System.out.println(example.getValue());
        System.out.println(example.getLength());
        System.out.println(example.isEmpty());
        System.out.println(example.toUpperCase());
    }
}
