package com.xxx.crazyjava.nio;

import java.nio.CharBuffer;

/**
 * @author zhwanwan
 * @create 2019-06-03 4:08 PM
 */
public class BufferTest {


    public static void main(String[] args) {
        CharBuffer buffer = CharBuffer.allocate(8);
        System.out.println("capacity: " + buffer.capacity());
        System.out.println("limit " + buffer.limit());
        System.out.println("position " + buffer.position());

        //add element
        buffer.put('a');
        buffer.put('b');
        buffer.put('c');

        System.out.println("加入三个元素后,position = " + buffer.position());

        //flip
        buffer.flip();
        System.out.println("执行flip()后，limit = " + buffer.limit());
        System.out.println("position = " + buffer.position());
        //取出第一个元素
        System.out.println("第一个元素(position=0): " + buffer.get());
        System.out.println("取出第一个元素后,position = " + buffer.position());
        //clear
        buffer.clear();
        System.out.println("执行clear()后,limit = " + buffer.limit());
        System.out.println("执行clear()后,position = " + buffer.position());
        System.out.println("执行clear()后,缓冲区内容并没有被清除,第三个元素为: " + buffer.get(2)); //绝对读取,position不变
        System.out.println("执行绝对读取后,position = " + buffer.position());

    }
}
