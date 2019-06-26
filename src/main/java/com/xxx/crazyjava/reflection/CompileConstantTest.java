package com.xxx.crazyjava.reflection;

/**
 * @author zhwanwan
 * @create 2019-06-10 4:50 PM
 */
public class CompileConstantTest {
    public static void main(String[] args) {
        System.out.println(MyTest.compileConstant);
    }
}

class MyTest {
    static {
        System.out.println("静态初始化块...");
    }

    //使用一个字符串直接量为static final Field赋值
    static final String compileConstant = "疯狂Java讲义";
}