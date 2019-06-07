package com.xxx.crazyjava.thread;

/**
 * @author zhwanwan
 * @create 2019-06-04 2:58 PM
 */
public class DaemonThread extends Thread {

    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(getName() + "  " + i);
        }
    }

    public static void main(String[] args) {
        DaemonThread t = new DaemonThread();
        t.setDaemon(true);// 将此线程设置成后台线程
        t.start();
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "  " + i);
        }
        // -----程序执行到此处，前台线程（main线程）结束------
        // 后台线程也应该随之结束
    }
}
