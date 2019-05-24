package com.xxx.jdk8.defmethod;

/**
 * @author wangzhen
 * @create 2019-05-24 6:01 AM
 */
public interface MyInterface1 {

    default void myMethod() {
        System.out.println("MyInterface1");
    }
}
