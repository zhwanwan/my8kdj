package com.xxx.jdk8.methodreference;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author wangzhen
 * @create 2019-05-24 4:59 AM
 */
public class MethodReferenceTest {
    public static void main(String[] args) {
        Student s1 = new Student("zhangsan", 10);
        Student s2 = new Student("lisi", 90);
        Student s3 = new Student("wangwu", 50);
        Student s4 = new Student("zhaoliu", 40);
        List<Student> students = Arrays.asList(s1, s2, s3, s4);
        //排序
//        students.sort((stu1, stu2) -> Student.compareStudentByScore(stu1, stu2));
        students.sort(Student::compareStudentByScore); //方法引用(静态)
        students.forEach(System.out::println);
        System.out.println("1--------------");
//        students.sort((stu1,stu2)->Student.compareStudentByName(stu1,stu2));
        students.sort(Student::compareStudentByName);
        students.forEach(System.out::println);
        System.out.println("2--------------");

        StudentComparator sc = new StudentComparator();
//        students.sort((stu1, stu2) -> sc.compareStuByScore(stu1, stu2));
        students.sort(sc::compareStuByScore);
        students.forEach(System.out::println);
        System.out.println("3--------------");
//        students.sort((stu1,stu2)->sc.compareStuByName(stu1,stu2));
        students.sort(sc::compareStuByName);
        students.forEach(System.out::println);
        System.out.println("4--------------");

//        students.sort((stu1, stu2) -> stu1.compareByScore(stu2));
        students.sort(Student::compareByScore);
        students.forEach(System.out::println);
        System.out.println("5--------------");
//        students.sort((stu1,stu2)->stu1.compareByName(stu2));
        students.sort(Student::compareByName);
        System.out.println("6--------------");

        List<String> cities = Arrays.asList("qingdao", "chongqing",
                "nanjing", "beijing", "shanghai", "suzhou");
//        Collections.sort(cities, (c1, c2) -> c1.compareToIgnoreCase(c2));
        Collections.sort(cities, String::compareToIgnoreCase);
        cities.forEach(System.out::println);
        System.out.println("7--------------");

        MethodReferenceTest mr = new MethodReferenceTest();
        System.out.println(mr.getString(String::new));
        System.out.println(mr.getString2("Hello", String::new));

    }

    public String getString(Supplier<String> supplier) {
        return supplier.get() + "test";
    }

    public String getString2(String str, Function<String, String> function) {
        return function.apply(str);
    }
}
