package com.xxx.jdk8;

import java.util.function.Predicate;

/**
 * @author wangzhen
 * @create 2019-05-22 6:15 PM
 */
public class PredicateTest {
    public static void main(String[] args) {
        Predicate<String> predicate = p -> p.length() > 5;
        System.out.println(predicate.test("hello oracle"));
    }
}
