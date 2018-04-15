package com.lwb.Study.lambda.day01;

import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Demo {
    private static Predicate<Integer> predicate = x -> x > 5;
    private static BinaryOperator<Long> binaryOperator = (x, y) -> x + y;
    private static Consumer<String> consumer = str -> System.out.println(str);
    private static Comparator<Integer> comparator = Comparator.comparingInt(x -> x);
    private static Integer count = Stream.of(1, 2).reduce(0, (x, y) -> x + y);
    public static void main(String[] args) {
        boolean flag = predicate.test(3);
        int rs = comparator.compare(3, 4);
        System.out.println(flag);
    }
}
