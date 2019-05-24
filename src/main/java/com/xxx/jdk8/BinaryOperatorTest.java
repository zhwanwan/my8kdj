package com.xxx.jdk8;

import java.util.Comparator;
import java.util.function.BinaryOperator;

/**
 * @author wangzhen
 * @create 2019-05-23 8:33 AM
 */
public class BinaryOperatorTest {
    public static void main(String[] args) {
        BinaryOperatorTest test = new BinaryOperatorTest();
        System.out.println(test.compute(1, 2, (a, b) -> a + b));
        System.out.println(test.compute(1, 2, (a, b) -> a - b));
        System.out.println("----------------");
        System.out.println(test.getShort("oracle", "mysql", (a, b) -> a.length() - b.length()));
        System.out.println(test.getShort("oracle", "mysql", (a, b) -> a.charAt(0) - b.charAt(0)));
    }

    public int compute(int a, int b, BinaryOperator<Integer> bo) {
        return bo.apply(a, b);
    }

    public String getShort(String a, String b, Comparator<String> comparator) {
        return BinaryOperator.minBy(comparator).apply(a, b);
    }
}
