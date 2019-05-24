package com.xxx.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

/**
 * @author wangzhen
 * @create 2019-05-22 5:41 PM
 */
public class PersonTest {
    public static void main(String[] args) {
        Person p1 = new Person("zhangsan", 20);
        Person p2 = new Person("lisi", 30);
        Person p3 = new Person("wangwu", 40);
        List<Person> persons = Arrays.asList(p1, p2, p3);
        PersonTest test = new PersonTest();
//        List<Person> results = test.getPersonByName("g", persons);
        List<Person> results = test.getPersonByAge(25, persons);
        results.forEach(p -> System.out.println(p.getUserName()));
        List<Person> personList = test.getPersonByAge(36, persons, (age, pList) -> pList.stream().filter(p -> p.getAge() <= age)
                .collect(Collectors.toList()));
        personList.forEach(p -> System.out.println(p.getUserName()));


    }

    public List<Person> getPersonByName(String name, List<Person> persons) {
        return persons.stream().filter(p -> p.getUserName().contains(name)).collect(Collectors.toList());
    }

    public List<Person> getPersonByAge(int age, List<Person> persons) {
        BiFunction<Integer, List<Person>, List<Person>> biFunction = (a, pList) -> {
            return pList.stream().filter(p -> p.getAge() >= a).collect(Collectors.toList());
        };
        return biFunction.apply(age, persons);
    }

    public List<Person> getPersonByAge2(int age, List<Person> persons) {
        BiFunction<Integer, List<Person>, List<Person>> biFunction = (a, pList) ->
                pList.stream().filter(p -> p.getAge() >= a).collect(Collectors.toList());
        return biFunction.apply(age, persons);
    }

    public List<Person> getPersonByAge(int age, List<Person> persons, BiFunction<Integer, List<Person>, List<Person>> bf) {
        return bf.apply(age, persons);
    }
}
