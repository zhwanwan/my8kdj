package com.xxx.jdk8.stream2;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;


/**
 * @author zhwanwan
 * @create 2019-05-26 10:21 AM
 */
public class StreamTest1 {

    public static void main(String[] args) {

        Student s1 = new Student("zhangsan", 80);
        Student s2 = new Student("lisi", 100);
        Student s3 = new Student("wangwu", 90);
        Student s4 = new Student("zhaoliu", 80);
        List<Student> students = Arrays.asList(s1, s2, s3, s4);
        List<Student> collect = students.stream().collect(toList());
        collect.forEach(System.out::println);
        System.out.println("----------------------");

        System.out.println("count " + students.stream().collect(Collectors.counting()));
        System.out.println("count " + (Long) students.stream().count());
        System.out.println("----------------------");

        Optional<Student> minStu = students.stream().collect(minBy(Comparator.comparingInt(Student::getScore)));
        minStu.ifPresent(System.out::println);
        Optional<Student> maxStu = students.stream().max(Comparator.comparingInt(Student::getScore));
        maxStu.ifPresent(System.out::println);
        Double avgScore = students.stream().collect(averagingInt(Student::getScore));
        System.out.println("平均分: " + avgScore);
        Integer sumScore = students.stream().collect(summingInt(Student::getScore));
        System.out.println("总分: " + sumScore);
        IntSummaryStatistics summaryStatistics = students.stream().collect(summarizingInt(Student::getScore));
        System.out.println(summaryStatistics);
        System.out.println(students.stream().map(Student::getName).collect(joining(",", "[", "]")));
        System.out.println("----------------------");

        /**
         * 二级分组
         */
        Map<Integer, Map<String, List<Student>>> integerMapMap
                = students.stream().collect(groupingBy(Student::getScore, groupingBy(Student::getName)));
        System.out.println(integerMapMap);
        System.out.println("----------------------");

        /**
         * 分区[<80,>=80]
         */
        Map<Boolean, List<Student>> booleanListMap = students.stream().collect(partitioningBy(s -> s.getScore() > 80));
        System.out.println(booleanListMap);
        System.out.println("----------------------");

        Map<Boolean, Map<Boolean, List<Student>>> booleanMapMap =
                students.stream().collect(partitioningBy(s -> s.getScore() > 80, partitioningBy(s -> s.getScore() > 90)));
        System.out.println(booleanMapMap);
        System.out.println("----------------------");

        Map<Boolean, Long> longMap = students.stream().collect(partitioningBy(s -> s.getScore() > 80, counting()));
        System.out.println(longMap);
        System.out.println("----------------------");

        Map<String, Student> studentMap = students.stream().collect(
                groupingBy(
                        Student::getName, //按名字分组
                        collectingAndThen(minBy(Comparator.comparingInt(Student::getScore)), Optional::get) //每组分数最低的学生
                )
        );
        System.out.println(studentMap);

    }
}
