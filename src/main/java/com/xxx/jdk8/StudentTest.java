package com.xxx.jdk8;

import java.util.function.Supplier;

/**
 * @author wangzhen
 * @create 2019-05-23 8:18 AM
 */
public class StudentTest {
    public static void main(String[] args) {
        Supplier<Student> supplier = () -> new Student();
        System.out.println(supplier.get());
        System.out.println("-------------");
        //构造方法引用
        Supplier<Student> supplier2 = Student::new;
        System.out.println(supplier2.get());
        System.out.println("-------------");

    }
}
