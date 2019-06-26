package com.xxx.crazyjava.reflection;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * @author zhwanwan
 * @create 2019-06-10 5:01 PM
 */
public class ClassLoaderPropTest {
    public static void main(String[] args) throws IOException {
        ClassLoader systemLoader = ClassLoader.getSystemClassLoader();
        System.out.println("系统加载器:" + systemLoader);
        /*
		获取系统类加载器的加载路径——通常由CLASSPATH环境变量指定
		如果操作系统没有指定CLASSPATH环境变量，默认以当前路径作为
		系统类加载器的加载路径
		*/
        Enumeration<URL> eml = systemLoader.getResources("");
        while (eml.hasMoreElements()) {
            System.out.println(eml.nextElement());
        }

        ClassLoader extensionLoader = systemLoader.getParent();

        System.out.println("扩展类加载器:" + extensionLoader);

        System.out.println("扩展类加载器路径: " + System.getProperty("java.ext.dirs"));

        System.out.println("扩展类加载器的parent: " + extensionLoader.getParent());

    }
}
