package com.xxx.crazyjava.thread.lock;

/**
 * @author zhwanwan
 * @create 2019-06-04 4:59 PM
 */
public class DeadLock implements Runnable {

    A a = new A();
    B b = new B();

    public void init() {
        Thread.currentThread().setName("主线程");
        a.foo(b);
        System.out.println("进入了主线程之后");
    }


    @Override
    public void run() {
        Thread.currentThread().setName("副线程");
        b.bar(a);
        System.out.println("进入了副线程之后");
    }


    public static void main(String[] args) {
        DeadLock dl = new DeadLock();
        new Thread(dl).start();
        //调用init方法
        dl.init();
    }

}

class A {

    public synchronized void foo(B b) {
        System.out.println("当前线程名: " + Thread.currentThread().getName()
                + " 进入了A实例的foo方法");     //①
        try {
            Thread.sleep(200);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("当前线程名: " + Thread.currentThread().getName()
                + " 企图调用B实例的last方法");    //③
        b.last();
    }

    public synchronized void last() {
        System.out.println("进入了A类的last方法内部");
    }
}

class B {

    public synchronized void bar(A a) {
        System.out.println("当前线程名: " + Thread.currentThread().getName()
                + " 进入了B实例的bar方法");   //②
        try {
            Thread.sleep(200);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("当前线程名: " + Thread.currentThread().getName()
                + " 企图调用A实例的last方法");  //④
        a.last();
    }

    public synchronized void last() {
        System.out.println("进入了B类的last方法内部");
    }
}