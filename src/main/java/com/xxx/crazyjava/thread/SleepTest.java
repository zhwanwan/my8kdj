package com.xxx.crazyjava.thread;

import java.util.Date;

/**
 * @author zhwanwan
 * @create 2019-06-04 3:03 PM
 */
public class SleepTest {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            System.out.println("当前时间: " + new Date());
            // 调用sleep方法让当前线程暂停1s。
            Thread.sleep(2000);
        }
    }
}
