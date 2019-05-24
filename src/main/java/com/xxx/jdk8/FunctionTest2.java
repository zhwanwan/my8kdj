package com.xxx.jdk8;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author wangzhen
 * @create 2019-05-22 3:04 PM
 */
public class FunctionTest2 {
    public static void main(String[] args) {
        FunctionTest2 test = new FunctionTest2();
        System.out.println(test.compute(2, v -> v * 3, v -> v * v)); //12
        System.out.println(test.compute2(2, v -> v * 3, v -> v * v)); //36
        System.out.println(test.compute3(1, 2, (i, j) -> i + j));
        System.out.println(test.compute3(1, 2, (i, j) -> i - j));
        System.out.println(test.compute3(1, 2, (i, j) -> i * j));
        System.out.println(test.compute3(1, 2, (i, j) -> i / j));
        System.out.println(test.compute4(2, 3, (i, j) -> i + j, i -> i * i));//25

    }

    public int compute(int a, Function<Integer, Integer> f1, Function<Integer, Integer> f2) {
        return f1.compose(f2).apply(a);
    }

    public int compute2(int a, Function<Integer, Integer> f1, Function<Integer, Integer> f2) {
        return f1.andThen(f2).apply(a);
    }

    public int compute3(int a, int b, BiFunction<Integer, Integer, Integer> bf) {
        return bf.apply(a, b);
    }

    public int compute4(int a, int b,
                        BiFunction<Integer, Integer, Integer> bf,
                        Function<Integer, Integer> f) {
        return bf.andThen(f).apply(a, b);
    }
}
