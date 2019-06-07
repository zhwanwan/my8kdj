package com.xxx.crazyjava.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhwanwan
 * @create 2019-06-05 12:22 PM
 */
public class ThreadPoolTest {
    public static void main(String[] args) {

        ExecutorService pool = Executors.newFixedThreadPool(6);

        Runnable target = () -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + "的i值为: " + i);
            }
        };

        pool.submit(target);
        pool.submit(target);
        //关闭线程池
        pool.shutdown();

    }
}
