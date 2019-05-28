package com.xxx.jdk8.stream2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author zhwanwan
 * @create 2019-05-28 12:50 PM
 */
public class MyComparatorTest {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("nihao", "hello", "world", "welcome");

/*
        Collections.sort(list, (s1, s2) -> s1.length() - s2.length());
        Collections.sort(list, Comparator.comparingInt(String::length));
        Collections.sort(list, Comparator.comparingInt((String s) -> s.length()).reversed());
        Collections.sort(list, Comparator.comparingInt(String::length)
                .thenComparing(String.CASE_INSENSITIVE_ORDER));
        Collections.sort(list, Comparator.comparingInt(String::length)
                .thenComparing((s1, s2) -> s1.toLowerCase().compareTo(s2.toLowerCase())));
        Collections.sort(list, Comparator.comparingInt(String::length)
                .thenComparing(Comparator.comparing(String::toLowerCase)));
        Collections.sort(list, Comparator.comparingInt(String::length)
                .thenComparing(Comparator.comparing(String::toLowerCase,Comparator.reverseOrder())));
*/

        /*Collections.sort(list, Comparator.comparingInt(String::length).reversed()
                .thenComparing(String::toLowerCase, Comparator.reverseOrder()));*/

        Collections.sort(list, Comparator.comparingInt(String::length).reversed()
                .thenComparing(String::toLowerCase, Comparator.reverseOrder())
                .thenComparing(Comparator.reverseOrder()));

        System.out.println(list);


    }
}
