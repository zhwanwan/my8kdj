package com.xxx.crazyjava.thread.pool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

/**
 * @author zhwanwan
 * @create 2019-06-05 2:52 PM
 */
public class Sum {
    public static void main(String[] args) {
        int[] arr = IntStream.range(1, 101).toArray();
        //创建一个通用池
        ForkJoinPool pool = new ForkJoinPool();
        Future<Integer> future = pool.submit(new CalTask(arr, 0, arr.length));
        try {
            System.out.println("计算总和: "+future.get());
            pool.shutdown();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }


    }
}

// 继承RecursiveTask来实现"可分解"的任务
class CalTask extends RecursiveTask<Integer> {

    // 每个“小任务”只最多只累加20个数
    private static final int THRESHOLD = 20;
    private int arr[];
    private int start;
    private int end;

    public CalTask(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {

        int sum = 0;
        // 当end与start之间的差小于THRESHOLD时，开始进行实际累加
        if (end - start < THRESHOLD) {
            for (int i = start; i < end; i++) {
                sum += arr[i];
            }
            System.out.println("已处理[" + start + "~" + end + "]的结果: " + sum);

            return sum;
        } else {
            // 如果当end与start之间的差大于THRESHOLD时，即要打印的数超过20个
            // 将大任务分解成两个小任务。
            int middle = (start + end) >>> 1;
            CalTask left = new CalTask(arr, start, middle);
            CalTask right = new CalTask(arr, middle, end);
            //并行执行两个小任务
            left.fork();
            right.fork();
            //累加结果
            return left.join() + right.join();
        }
    }
}