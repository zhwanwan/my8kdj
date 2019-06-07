package com.xxx.crazyjava.net;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author zhwanwan
 * @create 2019-06-07 6:53 PM
 */
public class Server {

    public static void main(String[] args) {

        try {
            // 创建一个ServerSocket，用于监听客户端Socket的连接请求
            ServerSocket ss = new ServerSocket(3000);
            // 采用循环不断接受来自客户端的请求
            while (true) {
                // 每当接受到客户端Socket的请求，服务器端也对应产生一个Socket
                Socket s = ss.accept();
                // 将Socket对应的输出流包装成PrintStream
                PrintStream ps = new PrintStream(s.getOutputStream());
                // 进行普通IO操作
                ps.println("Hello Java");
                // 关闭输出流，关闭Socket
                ps.close();
                s.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
