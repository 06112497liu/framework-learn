package com.lwb.Study.effectivejava;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Demo {

    @Test
    public void test01() {
        Person p = new Person.PersonBuilder("zhangsan", 25, "男")
                             .phone("110")
                             .email("126@78.com")
                             .build();
        System.out.println(p);
    }

    @Test
    public void test02() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Singleton s1 = Singleton.SINGLETON;
        Constructor<Singleton> con = Singleton.class.getDeclaredConstructor();
        con.setAccessible(true);
        Singleton s2 = con.newInstance();
        System.out.println(Singleton.SINGLETON == Singleton.SINGLETON);
    }
}
