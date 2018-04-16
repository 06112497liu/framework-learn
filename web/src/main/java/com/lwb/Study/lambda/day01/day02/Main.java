package com.lwb.Study.lambda.day01.day02;

import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    static Stream<String> names01 = Stream.of(
            "John Lennon", "Paul McCartney", "George Harrison", "Ringo Starr", "Pete Best", "Stuart Sutcliffe"
    );
    /**
     * 1.找出名字最长的艺术家（收集器方式）
     */
    @Test
    public void test01() {
        String rs = names01.collect(Collectors.maxBy(Comparator.comparing(String::length)))
                .orElseThrow(RuntimeException::new);
        System.out.println(rs);
    }

    /**
     * 1.找出名字最长的艺术家（reduce）
     */
    @Test
    public void test02() {
        String rs = names01.reduce((one, other) -> Comparator.comparing(String::length).compare(one, other) >= 0 ? one : other)
                .orElseThrow(RuntimeException::new);
        System.out.println(rs);
    }

    /**
     * 2.假设一个元素为单词的流，计算每个单词出现的次数。假设输入如下，则返回值为一
     *   个形如 [John → 3, Paul → 2, George → 1] 的 Map
     */
    static Stream<String> names02 = Stream.of("John", "Paul", "George", "John",
            "Paul", "John");
    @Test
    public void test03() {
        Map<String, Long> rs = names02.collect(Collectors.groupingBy(o -> o, Collectors.counting()));
        System.out.println(rs);
    }
}

