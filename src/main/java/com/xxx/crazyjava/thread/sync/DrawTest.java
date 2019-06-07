package com.xxx.crazyjava.thread.sync;

/**
 * @author zhwanwan
 * @create 2019-06-04 6:01 PM
 */
public class DrawTest {
    public static void main(String[] args) {
        // 创建一个账户
        Account acct = new Account("1234567", 0);
        new DrawThread("取钱者", acct, 800).start();
        new DepositThread("存款者甲", acct, 800).start();
//        new DepositThread("存款者乙", acct, 800).start();
//        new DepositThread("存款者丙", acct, 800).start();
    }
}
