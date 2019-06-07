package com.xxx.crazyjava.thread.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhwanwan
 * @create 2019-06-04 5:55 PM
 */
public class Account {

    private final Lock lock = new ReentrantLock();

    private final Condition cond = lock.newCondition();
    //标识账户中是否已有存款的旗标
    private boolean flag;


    private String accountNo;
    private double balance;

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public Account(String accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public Account() {
    }

    // 下面两个方法根据accountNo来重写hashCode()和equals()方法
    public int hashCode() {
        return accountNo.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj != null && obj.getClass() == Account.class) {
            Account target = (Account) obj;
            return target.getAccountNo().equals(accountNo);
        }
        return false;
    }

    public void draw(double drawAmount) {
        //加锁
        lock.lock();
        try {
            if (!flag) {
                cond.await();
            } else {
                //执行取钱
                System.out.println(Thread.currentThread().getName() +
                        " 取钱:" + drawAmount);
                balance -= drawAmount;
                System.out.println("账户余额为: " + balance);
                // 将标识账户是否已有存款的旗标设为false。
                flag = false;
                // 唤醒其他线程
                cond.signalAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void deposit(double depositAmount) {

        lock.lock();

        try {
            if (flag) {
                cond.await();
            } else {
                //执行存款
                System.out.println(Thread.currentThread().getName() +
                        " 存款:" + depositAmount);
                balance += depositAmount;
                System.out.println("账户余额为: " + balance);
                // 将表示账户是否已有存款的旗标设为true
                flag = true;
                cond.signalAll();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }


}
