package com.xxx.jdk8.stream2;

/**
 * @author zhwanwan
 * @create 2019-05-31 1:13 PM
 *
 * -------------
 * com.xxx.jdk8.stream2.LambdaTest@55080cc6
 * com.xxx.jdk8.stream2.LambdaTest$1@31bfbbf6
 *
 */
public class LambdaTest {

    Runnable r1 = () -> System.out.println(this);

    Runnable r2 = new Runnable() {
        @Override
        public void run() {
            System.out.println(this);
        }
    };

    public static void main(String[] args) {
        LambdaTest lambdaTest = new LambdaTest();
        Thread t1 = new Thread(lambdaTest.r1);
        t1.start();
        System.out.println("-------------");
        Thread t2 = new Thread(lambdaTest.r2);
        t2.start();
    }
}
