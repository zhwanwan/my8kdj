package com.xxx.jdk8.stream;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhwanwan
 * @create 2019-05-25 8:44 PM
 */
public class StreamTest7 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "java");
        list.stream().map(s -> s.substring(0, 1).toUpperCase() + s.substring(1)).forEach(System.out::println);
    }
}
