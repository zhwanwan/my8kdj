package com.xxx.jdk8;

import java.util.function.Supplier;

/**
 * @author wangzhen
 * @create 2019-05-23 8:14 AM
 */
public class SupplierTest {
    public static void main(String[] args) {
        Supplier<String> supplier = () -> "Hello World";
        System.out.println(supplier.get());
    }
}
