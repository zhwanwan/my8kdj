package com.xxx.crazyjava.generic;

/**
 * 泛型变量不能用泛型
 *
 * @author zhwanwan
 * @create 2019-06-01 4:47 PM
 */
public class R<T> {

    R info;

    public void foo(T msg){}

    public  static <T> void bar(T msg) {
    }
}
