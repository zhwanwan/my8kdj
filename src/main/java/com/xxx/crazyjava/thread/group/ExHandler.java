package com.xxx.crazyjava.thread.group;

/**
 * @author zhwanwan
 * @create 2019-06-04 10:19 PM
 */
public class ExHandler {

    public static void main(String[] args) throws InterruptedException {

        //设置主线程的异常处理器--对未处理异常进程检查
        Thread.currentThread().setUncaughtExceptionHandler(new MyExHandler());
        Thread.sleep(1000);
        int a = 5 / 0;

        System.out.println("程序正常结束!");
    }

}


class MyExHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println(t + " 线程出现了异常：" + e);
    }
}