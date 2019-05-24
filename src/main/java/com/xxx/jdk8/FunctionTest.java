package com.xxx.jdk8;

import java.util.function.Function;

/**
 * @author wangzhen
 * @create 2019-05-22 2:23 PM
 */
public class FunctionTest {
    public static void main(String[] args) {
        FunctionTest test = new FunctionTest();
        System.out.println(test.compute(1, s -> {
            return s * 2;
        }));
        System.out.println(test.compute(2, s -> 5 + s));
        System.out.println(test.compute(3, s -> s * s));
        System.out.println(test.convert(5, s -> String.valueOf(s + "helloworld")));

    }

    public int compute(int a, Function<Integer, Integer> function) {
        int result = function.apply(a);
        return result;
    }

    public String convert(int a, Function<Integer, String> function) {
        return function.apply(a);
    }

}
