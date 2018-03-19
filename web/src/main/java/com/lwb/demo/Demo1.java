package com.lwb.demo;

public class Demo1 {
    public static void main(String[] args) {
//        m01();
        m02();
    }
    public static void m01() {
        A a = new B();
        a = new B();
        A c = new B();
        B b = new B();
    }

    public static void m02() {
        C c = new D("haha");
    }
}

class A {
    static {
        System.out.println(1);
    }
    public A() {
        System.out.println(2);
    }
}

class B extends A {
    static {
        System.out.println("a");
    }
    public B() {
        System.out.println("b");
    }
}

class C {
    String param;
    public C() {
        System.out.println("c");
    }
}

class D extends C {
    public D(String param) {
        System.out.println(param);
    }
}