package com.xxx.crazyjava.nio;

import java.io.IOException;
import java.nio.file.*;

/**
 * @author zhwanwan
 * @create 2019-06-03 9:57 PM
 */
public class WatchServiceTest {

    public static void main(String[] args) {
        try {
            // 获取文件系统的WatchService对象
            WatchService watchService = FileSystems.getDefault().newWatchService();
            // 为C:盘根路径注册监听
            Paths.get("C:/").register(watchService,
                    StandardWatchEventKinds.ENTRY_CREATE,
                    StandardWatchEventKinds.ENTRY_DELETE,
                    StandardWatchEventKinds.ENTRY_MODIFY
            );
            while (true) {
                // 获取下一个文件改动事件
                WatchKey key = watchService.take(); //①
                for (WatchEvent<?> event : key.pollEvents()) {
                    System.out.println(event.context() + " 文件发生了 "
                            + event.kind() + " 事件!");
                }
                // 重设WatchKey
                boolean valid = key.reset();
                // 如果重设失败，退出监听
                if (!valid) {
                    break;
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
