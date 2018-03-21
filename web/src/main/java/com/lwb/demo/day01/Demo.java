package com.lwb.demo.day01;

public class Demo {

    public static void main(String[] args) {
        StringBuffer a = new StringBuffer("1");
        StringBuffer b = new StringBuffer("2");
        operate(a, b);
        System.out.println(a + "," + b);
        m01(2);
    }

    static void operate(StringBuffer x, StringBuffer y) {
        x.append(y);
        y = x;
    }

    static void m01(int i) {
        switch (i) {
            case 1:
                System.out.println(1);
                break;
            case 2:
            default:
                System.out.println(2);
        }
    }
}
