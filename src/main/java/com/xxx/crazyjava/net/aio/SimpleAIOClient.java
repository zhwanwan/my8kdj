package com.xxx.crazyjava.net.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.charset.Charset;
import java.util.concurrent.ExecutionException;

/**
 * @author zhwanwan
 * @create 2019-06-09 11:25 AM
 */
public class SimpleAIOClient {
    static final int PORT = 30000;

    public static void main(String[] args) {
        // 用于读取数据的ByteBuffer。
        ByteBuffer buff = ByteBuffer.allocate(1024);
        Charset utf = Charset.forName("UTF-8");

        try (
                // ①创建AsynchronousSocketChannel对象
                AsynchronousSocketChannel clientChannel
                        = AsynchronousSocketChannel.open();) {
            // ②连接远程服务器
            clientChannel.connect(new InetSocketAddress("127.0.0.1", PORT)).get();
            buff.clear();
            // ③从clientChannel中读取数据
            clientChannel.read(buff).get();
            buff.flip();
            // 将buff中内容转换为字符串
            String content = utf.decode(buff).toString();
            System.out.println("服务器信息:" + content);

        } catch (IOException | InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }
}
