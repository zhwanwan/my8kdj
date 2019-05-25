package com.xxx.jdk8.stream;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhwanwan
 * @create 2019-05-26 12:40 AM
 */
public class StreamTest12 {
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("Hi", "Hello", "你好");
        List<String> list2 = Arrays.asList("zhangsan", "lisi", "wangwu", "zhaoliu");
        /**
         * 输出:
         * Hi zhangsan
         * Hi lisi
         * Hi wangwu
         * Hi zhaoliu
         * Hello zhangsan
         * Hello lisi
         * Hello wangwu
         * Hello zhaoliu
         * 你好 zhangsan
         * 你好 lisi
         * 你好 wangwu
         * 你好 zhaoliu
         */
        list1.stream().flatMap(s1 -> list2.stream().map(s2 -> s1 + " " + s2)).forEach(System.out::println);
    }
}
