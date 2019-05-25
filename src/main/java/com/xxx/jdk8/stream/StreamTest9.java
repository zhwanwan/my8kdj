package com.xxx.jdk8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author zhwanwan
 * @create 2019-05-25 11:06 PM
 */
public class StreamTest9 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(5_000_000);
        for (int i = 0; i < 5_000_000; i++) {
            list.add(UUID.randomUUID().toString());
        }
        System.out.println("开始排序");
        long startTime = System.nanoTime();
        list.parallelStream().sorted().count(); //使用并行流:底层使用多线程
        long endTime = System.nanoTime();
        long millis = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
        System.out.println("耗时: " + millis);

    }
}
