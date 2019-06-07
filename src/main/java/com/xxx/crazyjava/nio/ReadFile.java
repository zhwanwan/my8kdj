package com.xxx.crazyjava.nio;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * @author zhwanwan
 * @create 2019-06-03 5:00 PM
 */
public class ReadFile {
    public static void main(String[] args) throws IOException {

        try (// 创建文件输入流
             FileInputStream fis = new FileInputStream("ReadFile.java");
             // 创建一个FileChannel
             FileChannel fcin = fis.getChannel()) {
            // 定义一个ByteBuffer对象，用于重复取水
            ByteBuffer bbuff = ByteBuffer.allocate(64);

            // 创建Charset对象
            Charset charset = Charset.forName("GBK");
            // 创建解码器(CharsetDecoder)对象
            CharsetDecoder decoder = charset.newDecoder();
            CharBuffer cbuff = null;
            // 将FileChannel中数据放入ByteBuffer中
            while (fcin.read(bbuff) != -1) {
                // 锁定Buffer的空白区
                bbuff.flip();
                // 将ByteBuffer的内容转码
                cbuff = decoder.decode(bbuff);
                System.out.print(cbuff);
                // 将Buffer初始化，为下一次读取数据做准备
                bbuff.clear();
            }
        }
    }
}
