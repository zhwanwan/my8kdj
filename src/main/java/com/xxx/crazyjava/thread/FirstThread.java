package com.xxx.crazyjava.thread;

/**
 * @author zhwanwan
 * @create 2019-06-04 1:44 PM
 */
public class FirstThread extends Thread {


    private int i;

    public void run() {
        for (; i < 100; i++) {

            // 当线程类继承Thread类时，直接使用this即可获取当前线程
            // Thread对象的getName()返回当前该线程的名字
            // 因此可以直接调用getName()方法返回当前线程的名
            System.out.println(getName() + " " + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (i == 20) {
                new FirstThread().start();
                new FirstThread().start();

                //lambda
                Runnable r = () -> {
                    System.out.println(Thread.currentThread().getName());
                };
                r.run();

            }
        }
    }


}
