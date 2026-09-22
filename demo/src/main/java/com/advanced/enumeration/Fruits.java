package com.advanced.enumeration;

/**
 * Sample enum used with {@code docs/concepts/enumeration/enumeration.md}.
 */
public enum Fruits {
    mangoes,
    pomegrante;

    public static void main(String[] args) {
        System.out.println(Fruits.mangoes);
        System.out.println(Fruits.pomegrante);
        System.out.println(Fruits.mangoes == Fruits.mangoes);
        System.out.println(Fruits.mangoes.getClass());
    }
}
