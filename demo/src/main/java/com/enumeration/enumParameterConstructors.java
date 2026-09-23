package com.enumeration;

enum fruits {

    apple(100), pomegrante(200), banana(50), avacado(150);

    int price;

    fruits(int price) {
        this.price = price;
    }
}

public class enumParameterConstructors {

    public static void main(String[] args) {
        for (fruits f : fruits.values()) {
            System.out.println(f + " costs " + f.price);
        }
    }

}
