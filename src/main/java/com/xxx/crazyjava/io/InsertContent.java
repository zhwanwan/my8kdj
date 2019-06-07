package com.xxx.crazyjava.io;

import java.io.*;

/**
 * @author zhwanwan
 * @create 2019-06-03 2:00 PM
 */
public class InsertContent {

    public static void insert(String fileName, long pos, String insertContent) throws IOException {
        File tmp = File.createTempFile("tmp", null);
        try (RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
             FileOutputStream tmpOut = new FileOutputStream(tmp);
             FileInputStream tmpIn = new FileInputStream(tmp);
        ) {
            raf.seek(pos);
            byte[] buf = new byte[64];
            int hasRed = 0;
            while ((hasRed = raf.read(buf)) > 0) {
                tmpOut.write(buf, 0, hasRed);
            }
            raf.seek(pos); //文件指针重新定位到pos位置
            raf.write(insertContent.getBytes());
            //追加临时文件的内容
            while ((hasRed = tmpIn.read(buf)) > 0) {
                raf.write(buf, 0, hasRed);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }
}
