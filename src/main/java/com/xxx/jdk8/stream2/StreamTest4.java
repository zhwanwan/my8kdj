package com.xxx.jdk8.stream2;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhwanwan
 * @create 2019-05-29 3:28 PM
 */
public class StreamTest4 {
    public static void main(String[] args) {
        /*//int mid = ((lo + fence) >>> 1) & ~1; // force midpoint to be even
        int lo = 0;
        int hi = 9;
        int mid = ((lo + hi) >>> 1) & ~1; // & ~1 取偶数
        System.out.println(~1);
        System.out.println(mid);*/
        List<String> list = Arrays.asList("hello", "world", "hello world");

        list.forEach(System.out::println);
//        list.add("Java"); //error
        Integer i = new Integer(100);
        Integer j = new Integer(100);
        System.out.println("new :" + (i == j));

        Integer a = Integer.valueOf(100);
        Integer b = Integer.valueOf(100);
        System.out.println("valueOf :" + (a == b));

        Integer c = new Integer(100);
        Integer d = 100;
        System.out.println(c == d); //false: d--Integer常量池,等价于 Integer.valueOf(100)

        Integer e = new Integer(100);
        int f = 100;
        System.out.println(e == f); //true: 自动拆箱
    }
}
