package com.xxx.jdk8.stream;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhwanwan
 * @create 2019-05-25 11:57 AM
 */
public class StreamTest5 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "test");
        list.stream().map(String::toUpperCase).forEach(System.out::println);
        System.out.println("------------------");
        List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5, 6);
        list2.stream().map(i -> i * i).forEach(System.out::println);
        System.out.println("------------------");
        //flat map

    }

}
