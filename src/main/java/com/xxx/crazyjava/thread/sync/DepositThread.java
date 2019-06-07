package com.xxx.crazyjava.thread.sync;

/**
 * @author zhwanwan
 * @create 2019-06-04 5:59 PM
 */
public class DepositThread extends Thread {
    // 模拟用户账户
    private Account account;
    // 当前取钱线程所希望存款的钱数
    private double depositAmount;

    public DepositThread(String name, Account account
            , double depositAmount) {
        super(name);
        this.account = account;
        this.depositAmount = depositAmount;
    }

    // 重复100次执行存款操作
    public void run() {
        for (int i = 0; i < 100; i++) {
            account.deposit(depositAmount);
        }
    }
}
