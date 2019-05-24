package com.xxx.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author wangzhen
 * @create 2019-05-24 8:23 AM
 */
public class StreamTest1 {
    public static void main(String[] args) {
        Stream stream = Stream.of("Java", "Oracle", "MySQL");
        String[] array = new String[]{"Java", "Oracle", "MySQL"};
        Stream stream1 = Stream.of(array);
        Stream stream2 = Arrays.stream(array);
        List<String> list = Arrays.asList("Java", "Oracle", "MySQL");
        Stream stream3 = list.stream();
    }
}
