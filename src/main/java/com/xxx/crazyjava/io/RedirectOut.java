package com.xxx.crazyjava.io;

import java.io.IOException;
import java.io.PrintStream;

/**
 * @author zhwanwan
 * @create 2019-06-03 12:37 PM
 */
public class RedirectOut {
    public static void main(String[] args) {
        try (PrintStream ps = new PrintStream("out.txt")) {
            // 将标准输出重定向到ps输出流
            System.setOut(ps);
            // 向标准输出输出一个字符串
            System.out.println("普通字符串");
            // 向标准输出输出一个对象
            System.out.println(new RedirectOut());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
