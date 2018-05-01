package com.lwb.Study.lambda.day04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class PersonService {
    //假设这个list是通过已有接口返回的所有Person集合
    private static List<Person> list = new ArrayList<Person>();
    static {
        Person e1 = new Person();
        e1.setName("zhangsan");
        list.add(e1);
    }


    public static List<Person> findByName(String name){
        List<Person> people = new ArrayList<Person>();
        for (Person p : list){
            if(name.equals(p.getName())){
                people.add(p);
            }
        }
        return people;
    }

    public static List<Person> findByGender(String gender){
        List<Person> people = new ArrayList<Person>();
        for (Person p : list){
            if(gender.equals(p.getGender())){
                people.add(p);
            }
        }
        return people;
    }

    public static List find(Criteria<Person> criteria) {
        return list.stream()
                   .filter(o -> criteria.match(o)).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        String name = "zhangsan";
        List<Person> rs = find(p -> name.equals(p.getName()));
        System.out.println(rs);
        System.out.println(String.join(",", Arrays.asList("1", "2")));
    }

}
interface Criteria<T> {
    boolean match(T t);
}

