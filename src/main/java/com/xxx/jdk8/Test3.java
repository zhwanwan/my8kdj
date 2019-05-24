package com.xxx.jdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * @author wangzhen
 * @create 2019-05-21 8:42 PM
 */
public class Test3 {
    public static void main(String[] args) {
        /*TheInterface i1 = ()->{};
        System.out.println(i1.getClass().getInterfaces()[0]);
        TheInterface2 i2 = ()->{};
        System.out.println(i2.getClass().getInterfaces()[0]);
        new Thread(()->{System.out.println("Hello World"); }).start();*/

        /*List<String> list = Arrays.asList("hello", "world", "hello world");
        list.forEach(item -> System.out.println(item.toUpperCase()));
        List<String> list2 = new ArrayList<>();
        list.forEach(s -> list2.add(s.toUpperCase()));
        list2.forEach(System.out::println);
        list.stream().map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));
        list.stream().map(String::toUpperCase).forEach(System.out::println);*/

        Function<String,String> function = String::toUpperCase;
        System.out.println(function.getClass().getInterfaces()[0]);
    }
}

@FunctionalInterface
interface TheInterface {
    void myMethod();
}

@FunctionalInterface
interface TheInterface2 {
    void myMethod2();
}