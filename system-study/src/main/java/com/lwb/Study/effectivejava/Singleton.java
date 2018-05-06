package com.lwb.Study.effectivejava;

import java.io.Serializable;

public class Singleton implements Serializable {

    public static final Singleton SINGLETON = new Singleton();

    private Singleton(){
        // 防止使用反射调用私有构造器创建对象
        if (SINGLETON != null)
            throw new RuntimeException("单例模式，禁止创建对象");
    }

    private static Singleton getInstance() {
        return SINGLETON;
    }


}
