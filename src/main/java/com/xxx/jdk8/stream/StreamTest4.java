package com.xxx.jdk8.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author zhwanwan
 * @create 2019-05-25 1:27 AM
 */
public class StreamTest4 {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("Hello", "World", "Rabbit");

        String[] strArray = stream.toArray(String[]::new); //len -> new String[len] 可以用方法引用替换
        Arrays.asList(strArray).forEach(System.out::println);
        System.out.println("---------------------");
        Stream<String> stream1 = Stream.of("Hello1", "World1", "Rabbit1");
        List<String> list1 = stream1.collect(
                ArrayList::new,   //() -> new ArrayList<String>()     [方法引用替换]--创建集合
                ArrayList::add,   //(lst, item) -> lst.add(item)      [方法引用替换]--将流中元素添加到集合中
                ArrayList::addAll //(lst1, lst2) -> lst1.addAll(lst2) [方法引用替换]--将创建的集合添加到真正要返回的集合中
        );    //stream1.collect(Collectors.toList()); 封装过的,使用简单

        list1.forEach(System.out::println);
        System.out.println("---------------------");

        Stream<String> stream2 = Stream.of("Hello2", "World2", "Rabbit2");
        List<String> list2 = stream2.collect(Collectors.toCollection(ArrayList::new));
        list2.forEach(System.out::println);
        System.out.println("---------------------");

        Stream<String> stream3 = Stream.of("Hello3", "World3", "Rabbit3");
        Set<String> set = stream3.collect(Collectors.toCollection(TreeSet::new));
        System.out.println(set.getClass());
        set.forEach(System.out::println);
        System.out.println("---------------------");

        Stream<String> stream4 = Stream.of("Hello4", "World4", "Rabbit4");
        String str = stream4.collect(Collectors.joining(",")).toLowerCase();
        System.out.println(str);
    }
}
