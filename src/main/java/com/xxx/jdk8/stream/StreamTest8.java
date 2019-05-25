package com.xxx.jdk8.stream;

import java.util.stream.IntStream;

/**
 * @author zhwanwan
 * @create 2019-05-25 8:55 PM
 */
public class StreamTest8 {
    public static void main(String[] args) {
//        IntStream.iterate(0, i -> (i + 1) % 2).distinct().limit(6).forEach(System.out::println); //产生问题,程序一直在运行
        IntStream.iterate(0, i -> (i + 1) % 2).limit(6).distinct().forEach(System.out::println); //正确使用
    }
}
