package com.xxx.crazyjava.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author zhwanwan
 * @create 2019-06-04 2:07 PM
 */
public class ThirdThread implements Callable<Integer> {


    // 实现call方法，作为线程执行体
    @Override
    public Integer call() throws Exception {

        int i = 0;
        for (; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "的循环变量i的值: " + i);
        }
        return i;
    }

    public static void main(String[] args) {
        // 创建Callable对象
        ThirdThread rt = new ThirdThread();
        // 使用FutureTask来包装Callable对象
        FutureTask<Integer> task = new FutureTask<>(rt);
        FutureTask<Integer> task2 = new FutureTask<>(() -> {
            int i = 0;
            for (; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "的循环变量i的值: " + i);
            }
            return i;
        });

        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "的循环变量i的值 " + i);
            if (i == 5) {
                // 实质还是以Callable对象来创建、并启动线程
                new Thread(task, "有返回值的线程").start();
                new Thread(task2, "有返回值的线程2").start();
            }
        }
        try {
            // 获取线程返回值
            System.out.println("子线程的返回值: " + task.get());
            System.out.println("子线程的返回值2: " + task2.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
