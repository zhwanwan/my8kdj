package com.xxx.jdk8.stream;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhwanwan
 * @create 2019-05-25 11:18 PM
 */
public class StreamTest10 {
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("hello", "world", "java");
        list1.stream().filter(s -> s.length() == 5).findFirst().ifPresent(System.out::println);
        System.out.println("---------------");
        List<String> list2 = Arrays.asList("hello", "world", "java");
        list2.stream().mapToInt(s -> s.length()).filter(l -> l == 5).findFirst().ifPresent(System.out::println);
        System.out.println("---------------");

        List<String> list3 = Arrays.asList("hello", "world", "java");
        /**
         * Stream的短路操作,找到第一个匹配,后面的不再执行
         */
        list3.stream().mapToInt(s -> {
            int length = s.length();
            System.out.println(s);
            return length;
        }).filter(l -> l == 5).findFirst().ifPresent(System.out::println);
    }
}
