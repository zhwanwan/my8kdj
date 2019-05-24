package com.xxx.jdk8.defmethod;

/**
 * @author wangzhen
 * @create 2019-05-24 6:02 AM
 */
public interface MyInterface2 {

    default void myMethod() {
        System.out.println("MyInterface2");
    }

}
