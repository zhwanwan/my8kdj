package com.xxx.crazyjava.net.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author zhwanwan
 * @create 2019-06-09 11:17 AM
 */
public class SimpleAIOServer {

    static final int PORT = 30000;

    public static void main(String[] args) {

        try (
                // ①创建AsynchronousServerSocketChannel对象。
                AsynchronousServerSocketChannel serverSocketChannel
                        = AsynchronousServerSocketChannel.open()) {

            // ②指定在指定地址、端口监听。
            serverSocketChannel.bind(new InetSocketAddress(PORT));
            while (true) {
                // ③采用循环接受来自客户端的连接
                Future<AsynchronousSocketChannel> future = serverSocketChannel.accept();
                // 获取连接完成后返回的AsynchronousSocketChannel
                AsynchronousSocketChannel socketChannel = future.get();
                // 执行输出
                socketChannel.write(ByteBuffer.wrap(
                        "AIO实现的非阻塞通信".getBytes("UTF-8"))).get();
            }
        } catch (IOException | ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

    }
}
