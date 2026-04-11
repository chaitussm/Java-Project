package com.fundamentals.literals;

public class NumericLiterals {
    
    public static void main(String[] args) {
        // Integer literals
        int decimalLiteral = 100; // Decimal literal
        int octalLiteral = 0100; // Octal literal (64 in decimal)
        int hexadecimalLiteral = 0x64; // Hexadecimal literal (100 in decimal)
        int binaryLiteral = 0b1100100; // Binary literal (100 in decimal)

        System.out.println("Decimal Literal: " + decimalLiteral);
        System.out.println("Octal Literal: " + octalLiteral);
        System.out.println("Hexadecimal Literal: " + hexadecimalLiteral);
        System.out.println("Binary Literal: " + binaryLiteral);

        // Floating-point literals
        float floatLiteral = 3.14f; // Float literal
        double doubleLiteral = 3.14; // Double literal

        System.out.println("Float Literal: " + floatLiteral);
        System.out.println("Double Literal: " + doubleLiteral);
    }

}