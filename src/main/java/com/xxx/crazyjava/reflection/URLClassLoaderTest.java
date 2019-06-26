package com.xxx.crazyjava.reflection;

import java.net.URL;
import java.net.URLClassLoader;
import java.sql.Connection;
import java.sql.Driver;
import java.util.Properties;

/**
 * @author zhwanwan
 * @create 2019-06-11 10:49 AM
 */
public class URLClassLoaderTest {

    private static Connection conn;

    private static Connection getConn(String url, String user, String pass) throws Exception {
        if (conn == null) {
            URL[] urls = {new URL("file:E://mysql-connector-java-3.1.10-bin.jar")};
            // 以默认的ClassLoader作为父ClassLoader，创建URLClassLoader
            URLClassLoader myClassLoader = new URLClassLoader(urls);
            // 加载MySQL的JDBC驱动，并创建默认实例
            Driver driver = (Driver) myClassLoader.loadClass("com.mysql.jdbc.Driver").newInstance();
            // 创建一个设置JDBC连接属性的Properties对象
            Properties props = new Properties();
            props.setProperty("user", user);
            props.setProperty("password", pass);
            conn = driver.connect(url, props);
        }
        return conn;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(getConn("jdbc:mysql://localhost:3306/mysql", "root", "root"));
    }


}
