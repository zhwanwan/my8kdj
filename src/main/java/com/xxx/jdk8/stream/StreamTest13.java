package com.xxx.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Stream--Group BY
 *
 * @author zhwanwan
 * @create 2019-05-26 12:54 AM
 */
public class StreamTest13 {
    public static void main(String[] args) {
        Student s1 = new Student("zhangsan", 100, 20);
        Student s2 = new Student("lisi", 90, 20);
        Student s3 = new Student("wangwu", 90, 30);
        Student s4 = new Student("zhangsan", 80, 40);

        List<Student> students = Arrays.asList(s1, s2, s3, s4);
        /**
         * 分组
         */
        Map<String, List<Student>> listMap = students.stream()
                .collect(Collectors.groupingBy(Student::getName));
        System.out.println(listMap);
        System.out.println("---------------");
        Map<String, Long> longMap = students.stream()
                .collect(Collectors.groupingBy(Student::getName, Collectors.counting()));
        System.out.println(longMap);
        System.out.println("---------------");
        //平均
        Map<String, Double> doubleMap = students.stream()
                .collect(Collectors.groupingBy(Student::getName, Collectors.averagingDouble(Student::getScore)));
        System.out.println(doubleMap);
        System.out.println("---------------");
        /**
         * 分区:分组的特殊情况,只有两个
         */
        Map<Boolean, List<Student>> map = students.stream().collect(Collectors.partitioningBy(s -> s.getScore() >= 90));
        System.out.println(map);


    }
}
