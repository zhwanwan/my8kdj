package com.xxx.jdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author wangzhen
 * @create 2019-05-21 3:50 PM
 */
public class Test1 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8);
        System.out.println("外部迭代");
        for(Integer i : list) {
            System.out.println(i);
        }
        System.out.println("-----------------");
        list.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });
        System.out.println("内部迭代");
        System.out.println("-------------------");
        list.forEach(i -> System.out.println(i));
        System.out.println("-------------------");
        list.forEach(System.out::println); //通过方法引用创建函数式接口实例
    }
}
