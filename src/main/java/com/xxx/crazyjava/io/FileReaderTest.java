package com.xxx.crazyjava.io;

import java.io.FileReader;
import java.io.IOException;

/**
 * @author zhwanwan
 * @create 2019-06-03 10:41 AM
 */
public class FileReaderTest {
    public static void main(String[] args) {
        try (FileReader fr = new FileReader("E:\\2019\\picc-platform\\my8kdj\\src\\main\\java\\com\\xxx\\crazyjava\\io\\FileReaderTest.java")) {
            char[] buff = new char[80];
            int hasRead = 0;
            while ((hasRead = fr.read(buff)) > 0) {
                System.out.println(new String(buff, 0, hasRead));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
