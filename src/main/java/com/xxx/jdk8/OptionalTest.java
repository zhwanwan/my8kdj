package com.xxx.jdk8;

import java.util.Optional;

/**
 * @author wangzhen
 * @create 2019-05-24 4:09 AM
 */
public class OptionalTest {
    public static void main(String[] args) {
        Optional<String> optional = Optional.ofNullable("Hello");
//        System.out.println(optional.get());
        optional.ifPresent(System.out::println); //推荐的optional使用方式
        System.out.println(optional.orElse("world"));
        System.out.println(optional.orElseGet(()->"Java"));
    }
}
