package com.lwb.Study.lambda.day05;

import com.lwb.vo.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Class {

    @Test
    public void test01() {
        User u1 = new User("zhangsan", "123");
        User u2 = new User("lisi", "568");
        User u3 = new User("lisi", "569");

        List<User> list = new ArrayList<>();
        list.add(u1); list.add(u2); list.add(u3); list.add(new User("lisi", "888"));
        Map<String, String> result = list.stream()
                .collect(Collectors.toMap(User::getUserName, User::getPassword, (x, y) -> y));
        System.out.println(result);
    }
}
