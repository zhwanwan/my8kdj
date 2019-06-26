package com.xxx.crazyjava.reflection;

/**
 * @author zhwanwan
 * @create 2019-06-10 4:52 PM
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        try {
            ClassLoader cl = ClassLoader.getSystemClassLoader();
            cl.loadClass("Tester");
            System.out.println("系统加载Tester类");
            // 下面语句才会初始化Tester类
            Class.forName("Tester");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class Tester {
    static {
        System.out.println("Tester类的静态初始化块...");
    }
}