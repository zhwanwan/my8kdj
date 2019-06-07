package com.xxx.crazyjava.nio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhwanwan
 * @create 2019-06-03 9:12 PM
 */
public class FilesTest {
    public static void main(String[] args) {
        try {
            Files.copy(Paths.get("FilesTest.java"), new FileOutputStream("a.txt"));
            System.out.println("FilesTest.java是否为隐藏文件："
                    + Files.isHidden(Paths.get("FilesTest.java")));
            // 一次性读取FilesTest.java文件的所有行
            List<String> lines = Files.readAllLines(Paths.get("FilesTest.java"), Charset.forName("UTF-8"));
            System.out.println(lines);
            // 判断指定文件的大小
            System.out.println("FilesTest.java的大小为："
                    + Files.size(Paths.get("FilesTest.java")));

            List<String> poem = new ArrayList<>();
            poem.add("水晶潭底银鱼跃");
            poem.add("清徐风中碧竿横");

            // 直接将多个字符串内容写入指定文件中
            Files.write(Paths.get("pome.txt"), poem, Charset.forName("UTF-8"));
            FileStore cStore = Files.getFileStore(Paths.get("C:"));

            // 判断C盘的总空间，可用空间
            System.out.println("C:共有空间：" + cStore.getTotalSpace());
            System.out.println("C:可用空间：" + cStore.getUsableSpace());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
