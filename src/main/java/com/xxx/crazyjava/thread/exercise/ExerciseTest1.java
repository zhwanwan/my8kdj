package com.xxx.crazyjava.thread.exercise;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhwanwan
 * @create 2019-06-05 4:16 PM
 */
public class ExerciseTest1 {

    public static void main(String[] args) throws InterruptedException {
        Obj obj = new Obj();
        new PrintNumber(obj).start();
        new PrintChar(obj).start();

    }
}

class Obj {
    private final Lock lock = new ReentrantLock();
    private final Condition cond = lock.newCondition();
    private boolean printNumFlag = true;


    public void printNumber() {
        lock.lock();
        try {
            for (int i = 1; i <= 52; i++) {
                System.out.print(i);
                if (!printNumFlag) {
                    cond.await();
                } else {
                    if (i % 2 == 0) {
                        printNumFlag = false;
                        cond.signalAll();
                        cond.await();
                    }
                }
            }
            cond.signalAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printChar() {
        lock.lock();
        try {
            for (char c = 'A'; c <= 'Z'; c++) {
                System.out.print(c);
                if (printNumFlag) {
                    cond.await();
                } else {
                    printNumFlag = true;
                    cond.signalAll();
                    cond.await();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}

class PrintNumber extends Thread {
    private Obj obj;

    public PrintNumber(Obj obj) {
        super();
        this.obj = obj;
    }

    public void run() {
        obj.printNumber();
    }

}

class PrintChar extends Thread {
    private Obj obj;

    public PrintChar(Obj obj) {
        super();
        this.obj = obj;
    }

    public void run() {
        obj.printChar();
    }
}