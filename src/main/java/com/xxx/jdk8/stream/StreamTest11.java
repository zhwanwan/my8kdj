package com.xxx.jdk8.stream;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhwanwan
 * @create 2019-05-25 11:35 PM
 */
public class StreamTest11 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello welcome", "world hello", "hello world hello", "hello welcome");
        /*list.stream()
                .map(s -> Arrays.asList(s.split(" ")))
                .flatMap(List::stream)
                .distinct()
                .forEach(System.out::println);*/
        list.stream()
                .map(s -> s.split(" "))
                .flatMap(Arrays::stream)
                .distinct()
                .forEach(System.out::println);
    }
}
