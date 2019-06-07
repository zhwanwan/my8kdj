package com.xxx.crazyjava.thread;

/**
 * @author zhwanwan
 * @create 2019-06-04 3:50 PM
 */
public class Account {

    // 封装账户编号、账户余额两个Field
    private String accountNo;
    private double balance;

    public Account() {
    }

    // 构造器
    public Account(String accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }
    // 此处省略了accountNo和balance两个Field的setter和getter方法

    // accountNo的setter和getter方法
    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountNo() {
        return this.accountNo;
    }

    // balance的setter和getter方法
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return this.balance;
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
            return target.accountNo.equalsIgnoreCase(accountNo);
        }
        return false;
    }

    // 提供一个线程安全draw()方法来完成取钱操作
    public synchronized void draw(double drawAmount) {
        // 账户余额大于取钱数目
        if (balance >= drawAmount) {
            // 吐出钞票
            System.out.println(Thread.currentThread().getName()
                    + "取钱成功！吐出钞票:" + drawAmount);
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            // 修改余额
            balance -= drawAmount;
            System.out.println("\t余额为: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName()
                    + "取钱失败！余额不足！");
        }
    }

}
