package com.example.demo;

public class Logs {

    static final String prefix = "****====> ";

    private static void printPrefix() {
        System.out.print(prefix);
    }

    public static void println(String str) {
        printPrefix();
        System.out.println(str);
    }

    public static void print(String str) {
        printPrefix();
        System.out.print(str);
    }
}
