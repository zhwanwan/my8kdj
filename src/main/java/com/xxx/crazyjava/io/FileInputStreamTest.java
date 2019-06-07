package com.xxx.crazyjava.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author zhwanwan
 * @create 2019-06-03 10:30 AM
 */
public class FileInputStreamTest {
    public static void main(String[] args) {
        try (InputStream ins = new FileInputStream("FileInputStreamTest.java")) {
            byte[] buff = new byte[1024];
            int hasRead = 0;
            while ((hasRead = ins.read(buff)) > 0) {
                System.out.println(new String(buff, 0, hasRead));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
