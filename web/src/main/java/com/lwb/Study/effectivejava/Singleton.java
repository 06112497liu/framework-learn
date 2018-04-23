package com.lwb.Study.effectivejava;

import org.springframework.expression.spel.ast.NullLiteral;

public class Singleton {

    public static final Singleton SINGLETON = new Singleton();

    private Singleton(){
        // 防止使用反射调用私有构造器创建单例模式
        if (SINGLETON != null)
            throw new RuntimeException("单例模式，禁止创建对象");
    }

    private Singleton getInstance() {
        return SINGLETON;
    }
}
