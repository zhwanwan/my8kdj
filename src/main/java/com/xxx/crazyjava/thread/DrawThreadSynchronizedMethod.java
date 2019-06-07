package com.xxx.crazyjava.thread;

/**
 * @author zhwanwan
 * @create 2019-06-04 3:57 PM
 */
public class DrawThreadSynchronizedMethod extends Thread {

    private Account account;

    private double drawAmount;

    public DrawThreadSynchronizedMethod(String name, Account account, double drawAmount) {
        super(name);
        this.account = account;
        this.drawAmount = drawAmount;
    }

    // 当多条线程修改同一个共享数据时，将涉及数据安全问题。
    public void run() {
        // 直接调用account对象的draw方法来执行取钱
        // 同步方法的同步监视器是this，this代表调用draw()方法的对象。
        // 也就是说：线程进入draw()方法之前，必须先对account对象的加锁。
        account.draw(drawAmount);

    }

}
