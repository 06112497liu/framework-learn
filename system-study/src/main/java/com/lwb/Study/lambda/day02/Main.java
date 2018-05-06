package com.lwb.Study.lambda.day02;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.lwb.bean.User;
import org.junit.Test;

import java.util.*;
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
    }

    static List<Artist> artists = new ArrayList<>();

    public void test04() {
        String result = artists.stream()
                               .map(Artist::getName)
                               .collect(Collectors.joining(",", "[", "]"));
    }

    static List<Album> albums = new ArrayList<>();
    public void test05() {
        Map<Artist, Long> albumsByArtist
                = albums.stream().collect(Collectors.groupingBy(Album::getArtist, Collectors.counting()));
        Map<Artist, Integer> numberOfAlbums = new HashMap<>();
    }

    public void test06() {
        albums.stream().collect(Collectors.groupingBy(Album::getArtist,
                Collectors.mapping(Album::getName, Collectors.toList())));
    }

    public void test07() {
        List<String> names = new ArrayList<>();
        List<User> usrs = names.parallelStream()
                .map(UserDao::queryUserByName)
                .flatMap(list -> list.stream())
                .collect(Collectors.toList());
    }

    public void test10() {
        List<User> list = Lists.newArrayList();
        Ordering<User> ordering = Ordering.natural()
                                          .nullsLast()
                                          .onResultOf(User::getUserName);
        List<User> sortList = ordering.sortedCopy(list);
    }

    public void test08() {
        Joiner joiner = Joiner.on(";").skipNulls(); // 跳过null值，否则会报错。
        String str = joiner.join("a", null, "b"); // 当然也接受集合和数组
        System.out.println(str); // a;b
        Joiner joiner1 = Joiner.on(";").useForNull("无数据"); // 用‘无数据’来代替null
        String str1 = joiner1.join("a", null, "b");
        System.out.println(str1); // a;无数据;b
    }

    public void test09() {
        Splitter splitter = Splitter.on(",") // 以","分割
                .trimResults() // 移除结果字符串的前导空白和尾部空白
                .omitEmptyStrings(); // 从结果中自动忽略空字符串
        Iterable<String> rs = splitter.split("a's, d dd ,  ,;.[,a  ,,");
        ArrayList<String> list = Lists.newArrayList(rs);
        for (String str : list) {
            System.out.println(str + ": " + str.length());
        }
    }


}
class UserDao {
    static List<User> queryUserByName(String name) {
        return new ArrayList<>();
    }
}
