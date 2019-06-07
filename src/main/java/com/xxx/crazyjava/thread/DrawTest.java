package com.xxx.crazyjava.thread;

/**
 * @author zhwanwan
 * @create 2019-06-04 4:07 PM
 */
public class DrawTest {
    public static void main(String[] args) {
        // 创建一个账户
        Account acct = new Account("1234567", 1000);
        // 模拟两个线程对同一个账户取钱
        new DrawThread("甲", acct, 800).start();
        new DrawThread("乙", acct, 800).start();
        System.out.println("---------同步方法实现-----------");
        Account account = new Account("88888888", 1000);
        new DrawThreadSynchronizedMethod("A", account, 800).start();
        new DrawThreadSynchronizedMethod("B", account, 800).start();
    }
}
