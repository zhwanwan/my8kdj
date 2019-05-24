package com.xxx.jdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wangzhen
 * @create 2019-05-24 4:41 AM
 */
public class MethodReferenceDemo {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Hello","World","Hello World");
        list.forEach(item -> System.out.println(item));
        list.forEach(System.out::println); //方法引用
    }
}
