package com.xxx.crazyjava.nio;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * @author zhwanwan
 * @create 2019-06-03 9:23 PM
 */
public class FileVisitorTest {
    public static void main(String[] args) {
        // 遍历E:\2019\picc-platform目录下的所有文件和子目录
        try {
            Files.walkFileTree(Paths.get("e:", "2019", "picc-platform"),
                    new SimpleFileVisitor<Path>() {
                        // 访问文件时候触发该方法
                        @Override
                        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                            System.out.println("正在访问: " + file + "文件");
                            // 找到了FileInputStreamTest.java文件
                            if (file.endsWith("FileInputStreamTest.java")) {
                                System.out.println("--已经找到目标文件--");
                                return FileVisitResult.TERMINATE;
                            }
                            return FileVisitResult.CONTINUE;
                        }

                        // 开始访问目录时触发该方法
                        @Override
                        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                            System.out.println("正在访问：" + dir + " 路径");
                            return FileVisitResult.CONTINUE;
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
