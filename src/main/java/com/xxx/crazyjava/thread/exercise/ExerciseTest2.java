package com.xxx.crazyjava.thread.exercise;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author zhwanwan
 * @create 2019-06-06 10:24 AM
 */
public class ExerciseTest2 {

    public static void main(String[] args) {

        ExerciseTest2 test2 = new ExerciseTest2();
        CarStore carStore = test2.new CarStore(new ArrayBlockingQueue<>(3));

        Runnable in = () -> {
            for (int i = 0; i < 10000; i++) {
                carStore.carIn();
            }
        };
        Runnable out = () -> {
            while (true) {
                carStore.carOut();
            }
        };

        new Thread(in).start();
        new Thread(in).start();
        new Thread(in).start();
        new Thread(out).start();
        new Thread(out).start();

    }


    class CarStore {

        private BlockingQueue<Integer> bq;

        public CarStore(BlockingQueue<Integer> bq) {
            this.bq = bq;
        }

        public synchronized void carIn() {
            for (int i = 1; i <= 3; i++) {
                try {
                    //queue  put方法尝试加入新元素，如果是满队列，会进入wait状态
                    if (!bq.contains(i)) {
                        notifyAll();
                        bq.put(i);
                        Thread.sleep(500);
                        System.out.println(Thread.currentThread().getName() + "入库" + i);
                    }


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public synchronized void carOut() {
            try {
                Thread.sleep(1000);
                if (!bq.isEmpty())
                    System.out.println(Thread.currentThread().getName() + "退出" + bq.peek());
                //queue  take方法尝试取出并删除队首元素，空队列则会进入阻塞状态
                notifyAll();
                bq.take();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
