package com.classpathdemo;

import java.util.Properties;

/** Lists JVM system properties (Notepad++ demo). */
public class PrintSystemProperties {

    public static void main(String[] args) {
        Properties p = System.getProperties();
        p.list(System.out);
    }
}
