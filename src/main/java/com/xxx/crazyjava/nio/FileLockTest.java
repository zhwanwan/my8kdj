package com.xxx.crazyjava.nio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * @author zhwanwan
 * @create 2019-06-03 5:44 PM
 */
public class FileLockTest {
    public static void main(String[] args) {
        // 使用FileOutputStream获取FileChannel
        try (FileChannel channel = new FileOutputStream("a.txt").getChannel()) {
            // 使用非阻塞式方式对指定文件加锁
            FileLock lock = channel.tryLock();//排他锁
            Thread.sleep(10_000);
            //释放锁
            lock.release();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
