package com.xxx.crazyjava.nio;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author zhwanwan
 * @create 2019-06-03 4:57 PM
 */
public class RandomFileChannelTest {
    public static void main(String[] args) {
        File f = new File("a.txt");
        try (// 创建一个RandomAccessFile对象
             RandomAccessFile raf = new RandomAccessFile(f, "rw");
             // 获取RandomAccessFile对应的Channel
             FileChannel randomChannel = raf.getChannel()
        ) {
            // 将Channel中所有数据映射成ByteBuffer
            ByteBuffer buffer = randomChannel.map(FileChannel.MapMode.READ_ONLY, 0, f.length());
            // 把Channel的记录指针移动到最后
            randomChannel.position(f.length());
            // 将buffer中所有数据输出
            randomChannel.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
