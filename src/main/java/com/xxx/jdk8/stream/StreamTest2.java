package com.xxx.jdk8.stream;

import java.util.stream.IntStream;

/**
 * @author wangzhen
 * @create 2019-05-24 8:27 AM
 */
public class StreamTest2 {
    public static void main(String[] args) {
        IntStream intStream = IntStream.of(new int[]{1, 2, 3, 4});
        intStream.forEach(System.out::println);
        System.out.println("--------");
        IntStream.range(3,8).forEach(System.out::println);
        System.out.println("--------");
        IntStream.rangeClosed(3,8).forEach(System.out::println);
        System.out.println("--------");

    }
}
