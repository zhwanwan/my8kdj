package com.xxx.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author wangzhen
 * @create 2019-05-22 6:23 PM
 */
public class PredicateTest2 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        PredicateTest2 test = new PredicateTest2();
        test.conditionFilter(list, i -> i % 2 == 0);
        System.out.println("-------------------");
        test.conditionFilter(list, i -> i % 2 != 0);
        System.out.println("-------------------");
        test.conditionFilter(list, i -> i > 5);
        System.out.println("-------------------");
        test.conditionFilter(list, i -> true);
        System.out.println("-------------------");
        test.conditionFilter2(list, i -> i > 5, i -> i % 2 == 0);//大于5&&偶数
        System.out.println("-------------------");
        System.out.println(test.isEqual("test").test("test"));

    }

    public void conditionFilter(List<Integer> list, Predicate<Integer> predicate) {
        for (int i : list) {
            if (predicate.test(i))
                System.out.println(i);
        }
    }

    public void conditionFilter2(List<Integer> list, Predicate<Integer> p1, Predicate<Integer> p2) {
        for (int i : list) {
            if (p1.and(p2).negate().test(i))
                System.out.println(i);
        }
    }

    public Predicate<String> isEqual(Object o){
        return Predicate.isEqual(o);
    }
}
