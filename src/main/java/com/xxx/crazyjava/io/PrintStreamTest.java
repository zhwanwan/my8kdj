package com.xxx.crazyjava.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * @author zhwanwan
 * @create 2019-06-03 11:06 AM
 */
public class PrintStreamTest {

    public static void main(String[] args) {
        try (FileOutputStream fos = new FileOutputStream("test.txt");
             PrintStream ps = new PrintStream(fos)
        ) {
            ps.println("normal string"); //
            ps.println(new PrintStreamTest());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
