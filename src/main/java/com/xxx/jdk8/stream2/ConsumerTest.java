package com.xxx.jdk8.stream2;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

/**
 * @author zhwanwan
 * @create 2019-05-30 10:09 PM
 */
public class ConsumerTest {
    public static void main(String[] args) {
        ConsumerTest consumerTest = new ConsumerTest();

        Consumer<Integer> consumer = i -> System.out.println(i);
        IntConsumer intConsumer = System.out::println;

        consumerTest.test(consumer); //面向对象方式
        consumerTest.test(consumer::accept); //函数式方式
        consumerTest.test(intConsumer::accept); //函数式方式

        System.out.println("---------------------------------");

        int a = 0x00000004;
        int b = 2;

        /*System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(b));*/
        System.out.println(Integer.toHexString(a));
        System.out.println(Integer.toHexString(b));

        System.out.println(a == b);
        System.out.println(Integer.toHexString(a&b));
        System.out.println((b & a) == 0);

    }

    public void test(Consumer<Integer> consumer) {
        consumer.accept(100);
    }


}
