package com.xxx.crazyjava.io;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author zhwanwan
 * @create 2019-06-03 1:57 PM
 */
public class AppendContent {
    public static void main(String[] args) {
        try (RandomAccessFile raf = new RandomAccessFile("out.txt", "rw")) {
            raf.seek(raf.length());
            raf.write("追加内容".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
