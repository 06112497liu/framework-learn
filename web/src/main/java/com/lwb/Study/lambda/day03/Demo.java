package com.lwb.Study.lambda.day03;

public class Demo implements A, B{

    @Override
    public int hello() {
        return 0;
    }
}

interface A {
    int hello();
}

interface B {
    int hello();
}
