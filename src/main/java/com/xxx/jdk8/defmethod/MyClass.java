package com.xxx.jdk8.defmethod;

/**
 * @author wangzhen
 * @create 2019-05-24 6:03 AM
 */
public class MyClass implements MyInterface1,MyInterface2 {

    @Override
    public void myMethod() {
        MyInterface2.super.myMethod();
    }

    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.myMethod();
    }
}
