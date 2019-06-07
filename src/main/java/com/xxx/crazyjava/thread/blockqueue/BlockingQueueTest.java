package com.xxx.crazyjava.thread.blockqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author zhwanwan
 * @create 2019-06-04 9:17 PM
 */
public class BlockingQueueTest {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> bq = new ArrayBlockingQueue<>(2);
        bq.put("Java");//与bq.add("Java"、bq.offer("Java")相同
        bq.put("Java");//与bq.add("Java"、bq.offer("Java")相同
        bq.put("Java");//① 阻塞线程。
//        bq.take();
    }
}
